import java.util.*;
class Solution
{
    public int solution(String s){
        
        char[] chars = s.toCharArray();
        
        // dp[x][y]일 때 팰린드롬인지 아닌지 
        int[][]dp = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i] = 1;
        }
        
        for(int i=0;i+1<s.length();i++){
            if(chars[i]==chars[i+1])dp[i][i+1] = 1;
        }
        
        
        for(int i=2;i<s.length();i++){
            for(int j=0;j+i<s.length();j++){
                if(chars[j]==chars[j+i] && dp[j+1][j+i-1]==1){
                    dp[j][i+j]=1;
                }
            }
        }
        
        int max = 0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(dp[i][j]==1 || dp[j][i]==1){
                    max = Math.max(max,Math.abs(i-j)+1);
                } 
            }
        }
        return max;
        
        
    }
        
}

//투포인터
//슬라이딩 윈도우


