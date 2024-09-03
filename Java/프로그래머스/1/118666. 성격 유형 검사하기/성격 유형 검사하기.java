import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        
        Map<String,Integer> typeMap = new HashMap<>();
        String[] types = {"R","T","C","F","J","M","A","N"};
        
        for(String type : types){
            typeMap.put(type ,0);
        }
        
        for(int i = 0 ; i<survey.length;i++){
            char character =  survey[i].charAt(choices[i]/4);
            int point = typeMap.get(String.valueOf(character));
            point = point + Math.abs((1-choices[i]/4)*(-4) + choices[i]%4);
            typeMap.replace(String.valueOf(character), point);
        } 
    
        String answer = "";
        for(int i = 0;i<7;i=i+2){
            int first = typeMap.get(types[i]);
            int second = typeMap.get(types[i+1]);
            
            if(second>first){answer = answer+ types[i+1];}
            else{answer = answer+ types[i];}
        }
        return answer;
    }
}