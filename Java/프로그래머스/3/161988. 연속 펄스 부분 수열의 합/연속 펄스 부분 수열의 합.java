import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        
        int[] sec1 = new int[sequence.length];
        int[] sec2 = new int[sequence.length];
        
        for(int i=0;i<sequence.length;i++){
            if(i%2==0){
                sec1[i] = sequence[i]*(-1);
                sec2[i] = sequence[i];
            }
            else{
                sec1[i] = sequence[i];
                sec2[i] = sequence[i]*(-1);
            }
        }
        
        long max = 0;
        long current = 0;
        for(int value : sec1){
            if(value>0){
                current = Math.max(current,0);
                current = current + value;
                max = Math.max(max,current);
            }
            else if(value<0){
                current = current + value;
            }
        }
        
        long max2 = 0;
        current = 0;
        for(int value : sec2){
            if(value>0){
                current = Math.max(current,0);
                current = current + value;
                max2 = Math.max(max2,current);
            }
            else if(value<0){
                current = current + value;
            }
        }
        
        
        long answer = Math.max(max,max2);
        return answer;
    }
}