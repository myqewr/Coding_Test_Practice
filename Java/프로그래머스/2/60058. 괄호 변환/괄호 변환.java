import java.util.*;
class Solution {
    
    public Boolean check(List<String> pList){
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(int i=0;i<pList.size();i++){
            if(pList.get(i).equals("(")){
                left.add(i);
            }
            else{right.add(i);}
        }
        
        for(int i =0 ; i<left.size();i++){
            if(left.get(i)>right.get(i)){return false;}
        }
        return true;
    }
    
    public String recursive(List<String> pList){
        
        if(pList.size()==0){return "";}
        if(check(pList)){
            String result = "";
            for(String pp: pList){
                result+=pp;
            }
            return result;
        }
        
        List<String> u = new ArrayList<>();
        List<String> v = new ArrayList<>();
        
        int leftNum =0;
        int rightNum = 0;
        
        //u 분리
        for(String pTemp : pList){
            if(pTemp.equals("(")){
                leftNum+=1;
            }
            else{rightNum+=1;}
            u.add(pTemp);
            if(leftNum==rightNum){
                break;
            }
        }
        //v 분리
        for(int i = leftNum*2 ; i<pList.size();i++){
            v.add(pList.get(i));
        }
        // u가 닫힘
        String result = "";
        if(check(u)){
            for(String s : u){
                result+= s;
            }
             result+=recursive(v);
            return result;
        }
        //u가 안닫힘
        result+="(";
        result+= recursive(v);
        result+=")";
        
        for(int i=1;i<u.size()-1;i++){
            if(u.get(i).equals("(")){
                result+=")";
            }
            else{
                result+="(";
            }
        }
        return result;
    }
    
    
    public String solution(String p) {
        
       List<String> pList = new ArrayList<>(); 
        char[] pChars = p.toCharArray();
        for(char a : p.toCharArray()){
            pList.add(String.valueOf(a));
        }
        
        String answer = recursive(pList);
        
        return answer;
    }
}