import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] stones, int k) {
        
        int[] temp = stones.clone(); 
        Arrays.sort(temp);
        int answer = temp[0];
        int end = temp[stones.length-1]+1;
        int start = answer;
        
        while(end>start){
            int mid = (start+end)/2;
            
            if(valid(mid,stones,k)){
                start = mid+1;
            }
            else{end = mid;}
        }
        return start-1;
    }
    
    public Boolean valid(int mid,int[] stones, int k){
        
        int count = 0;
        for(int i=0;i<stones.length;i++){
            if(stones[i]<=mid-1){count++;}
            else{count = 0;}
            if(count == k){return false;}
        }
        return true;
    }
    
}