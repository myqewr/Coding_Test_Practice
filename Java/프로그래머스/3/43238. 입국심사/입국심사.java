import java.util.*;
class Solution {
    
    public boolean validation(int[] times, long time, int n){
        long num = 0;
        for(int t : times){
            num+=time/t;
        }
        return n<=num;
    }
    
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long maxTime = (long)n * times[times.length-1];
        long minTime = 0L;
        
        while(maxTime>minTime){
            
            long time = (maxTime+minTime)/2;
            
            if(validation(times,time,n)){
                maxTime = time;
            }
            else{
                minTime = time + 1;
            }
        }
        return minTime;
    }
}