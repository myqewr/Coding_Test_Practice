import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args){
        int n =0;
        int m =0;
        List<Integer> moneyList = new ArrayList<>();
        
        try{
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            m = sc.nextInt();
            
            for(int i=0;i<n;i++){
                moneyList.add(sc.nextInt());
            } 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        int[] dp = new int[m+1];
        dp[0] = 1;
        
        for(int money : moneyList){
            for(int total= money ;total<=m;total++){
                dp[total] += dp[total-money];
            }
        }
        System.out.println(dp[m]);
    }
}