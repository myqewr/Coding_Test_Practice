import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        
        int len = routes.length;
        Arrays.sort(routes,(a,b)->a[1]-b[1]);
        
        int num=0;
        int x=0;
        boolean bool  = true;
        while(bool){
            num++;
            int out = routes[x][1];
            for(int i = x; i<routes.length;i++){
                if(out<routes[i][0] || out>routes[i][1]){
                    x = i;
                    break;
                }
                if(i==routes.length-1){bool = false;}
            }
        }
        return num;
    }
}