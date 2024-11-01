import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        int n =0 ;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        if(n==0){System.out.println(0);return;}
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
      
        
        for(int i=2;i<=n;i++){
            int min = dp[i-1];
            if(i%2==0){min = Math.min(min,dp[i/2]);}
            if(i%3==0){min = Math.min(min,dp[i/3]);}
         
            dp[i] = min+1;
        }
        
        System.out.println(dp[n]);
    }
}