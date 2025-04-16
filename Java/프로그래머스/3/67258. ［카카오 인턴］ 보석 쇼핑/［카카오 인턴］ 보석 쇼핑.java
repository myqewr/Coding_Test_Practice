import java.util.*;
import java.util.stream.Collectors;
class Solution {
    
    public int[] solution(String[] gems) {
        int size = gems.length;
        int total = (int)Arrays.stream(gems).distinct().count();
        int s = 0;
        int sMin = 0;
        int f = s;
        int min = size;
        
        Map<String,Integer> map = new HashMap<>();
        map.put(gems[0],1);
    
        while(f!=size &&s<=f){
            if(map.size() == total){
                if(min>f-s+1){
                    min = f-s+1;
                    sMin = s;
                }
                map.put(gems[s],map.get(gems[s])-1);
                if(map.get(gems[s])==0){map.remove(gems[s]);}
                s++;
            }
            else{
                f++;
                if(f<size)map.put(gems[f],map.getOrDefault(gems[f],0)+1);
            }
        }
        
        int[] answer = {sMin+1,sMin+min};
        return answer;
    }
}

