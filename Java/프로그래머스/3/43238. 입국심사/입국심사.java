import java.util.*;
class Solution {
    
    public long solution(int n, int[] times) {
        double up = 0;
        double down = 1;
        for(int time: times){
            down*=(double)time;
            up+=(double)time;
        }
        
        Arrays.sort(times);
        long maxTime = times[times.length-1];
        
        long l = 0;
        long r = maxTime *n; 
        long mid = (l+r)/2;
        
        while(l<r){
            
            if(check(times,mid)>=(long)n){
                r = mid;
            }
            else{
                l = mid+1;
            }
            mid = (l+r)/2;
            
        }
        
        return l;
    }
    
    long check(int[] times, long min){
        long sum=0;
        for(int time:times){
            sum+=min/time;
        }
        return sum;
    }
    
        
}