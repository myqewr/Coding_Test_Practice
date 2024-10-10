import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        
        int[][] gr = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        
        for(int i=1;i<=n;i++){
            gr[i][i]=1;dp[i][i]=1;
        }
        for(int[] result : results){
            gr[result[0]][result[1]]=1;
        }
        
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(gr[i][k]+gr[k][j]==2){
                        gr[i][j]=1;
                        dp[i][j] =1;
                        dp[j][i] =1;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i=1; i<=n;i++){
            int num=0;
            for(int j=1;j<=n;j++){
                num+=dp[i][j];
            }
            if(num==n){answer++;}
        }
        
        return answer;
    }
    
}