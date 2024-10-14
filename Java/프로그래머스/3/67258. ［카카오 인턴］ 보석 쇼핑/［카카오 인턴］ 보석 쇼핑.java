import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String[] gems) {
        List<String> gemList =  Arrays.asList(gems);
        int num = new HashSet<>(gemList).size();
        Map<String,Integer> map = new HashMap<>();
        
        int[] answer = {0,0};
        int start = 0;
        int minNum = gems.length+1;
        for(int i=0;i<gems.length;i++){
            map.put(gems[i],i);
            if(gems[i].equals(gems[start])){
                int min = gems.length+1;
                for(int value : map.values()){
                    min = Math.min(min,value);
                }
                start= min;
            }
            if(map.size()==num){
                if(minNum>i-start+1){
                    minNum = i-start +1;
                    answer[0] = start+1;
                    answer[1] = i+1;
                    if(minNum == num){return answer;}
                }
            }
        }
        return answer;
    }
}