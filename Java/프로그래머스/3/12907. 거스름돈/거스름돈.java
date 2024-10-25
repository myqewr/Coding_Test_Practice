import java.util.*;
import java.util.stream.Collectors;
class Solution {
    
    public int solution(int n, int[] money) {
        //해당 금액을 만들 수 있는 경우의 수
        int[] dp = new int[n+1];
        dp[0]=1;
        
        for(int eachMoney : money){
            for(int i = eachMoney;i<=n;i++){
                dp[i] += dp[i-eachMoney];
            }
        }
        return dp[n];
    }
    
}