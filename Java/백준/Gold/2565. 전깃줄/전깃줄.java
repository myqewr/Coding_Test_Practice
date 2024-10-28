import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = 0; 
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        try{
            n = Integer.parseInt(br.readLine());
            for(int i = 0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                map.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        
        int[] dp = new int[501];
        for(int i=0;i<list.size();i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(list.get(j)<list.get(i)){
                    max = Math.max(dp[list.get(j)],max);
                }
            }
            dp[list.get(i)] = max+1;
        }
        int max = 0;
        for(int value : dp){
           max = Math.max(max,value);
        }
        System.out.println(n-max);
    }
}
