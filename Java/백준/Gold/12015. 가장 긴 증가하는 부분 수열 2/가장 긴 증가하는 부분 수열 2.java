import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args){
    
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        
        Integer[] lis = new Integer[n]; 
        lis[0] = list.get(0);
        int len = 1;
        
        for(int i=1;i<n;i++){
            int start = 0;
            int end = len-1;
            int value = list.get(i);
            
            if(value > lis[len-1]){
                lis[len] = value;
                len++;
                continue;
            }
            
            while(start<end){
                int mid = (start+end)/2;
                if(lis[mid]<value){
                    start = mid+1;
                }
                else{end = mid;}
            }
            lis[end] = value; 
        }
        System.out.println(len);
    }
    
}