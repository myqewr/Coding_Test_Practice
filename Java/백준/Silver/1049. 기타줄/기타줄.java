import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args){
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =0;int m=0;
        try{
            String[] nm= br.readLine().split(" ");
            n = Integer.parseInt(nm[0]);
            m = Integer.parseInt(nm[1]);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        List<Integer[]> list = new ArrayList<>();
        
        try{
            for(int i=0;i<m;i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                Integer[] ab = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
                list.add(ab);
            } 
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        int sixMinPrice = Integer.MAX_VALUE;
        int oneMinPrice = Integer.MAX_VALUE;
        for(Integer[] price : list){
            sixMinPrice = Math.min(Math.min(sixMinPrice, price[0]),price[1]*6);
            oneMinPrice = Math.min(oneMinPrice, price[1]);
        }
        
        
        int totalPrice = n/6 * sixMinPrice ;
        totalPrice += Math.min(sixMinPrice , oneMinPrice*(n%6));
        
        System.out.println(totalPrice);
    }
    
}


