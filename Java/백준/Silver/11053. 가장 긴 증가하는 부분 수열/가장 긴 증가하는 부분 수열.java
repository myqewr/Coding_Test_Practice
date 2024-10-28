import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args){
    
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        int[] dp = new int[n];
        
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(list.get(i)<list.get(j)){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            dp[i]++;
        }
        int max =0;
        for(int value : dp){
            max = Math.max(max,value);
        }
        System.out.println(max);
    }
    
}