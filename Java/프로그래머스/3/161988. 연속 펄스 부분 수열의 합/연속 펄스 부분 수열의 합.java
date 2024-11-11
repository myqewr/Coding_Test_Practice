import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        
        int len = sequence.length;
        
        long[][] dp = new long[len][2]; 
        
        long[] seq1 = new long[len];
        long[] seq2 = new long[len];
        for(int i=0;i<len;i++){
            if(i%2==0){
                seq1[i] = sequence[i]*(-1);
                seq2[i] = sequence[i];
            }
            else{
                seq1[i] = sequence[i];
                seq2[i] = sequence[i]*(-1);
            }
        }
        dp[0][0] = seq1[0]; dp[0][1] = seq2[0];
        for(int i=1;i<len;i++){
            dp[i][0] = Math.max(dp[i-1][0]+seq1[i], seq1[i]);
            dp[i][1] = Math.max(dp[i-1][1]+seq2[i], seq2[i]);
        }
        
        long max=0;
        for(long[] value : dp){
            long temp = Math.max(value[0],value[1]);
            max = Math.max(temp,max);
        }

        return max;
    }
}