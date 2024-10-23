import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes,(a,b)->a[1]-b[1]);
        int num=1;
        int out = 0;
        for(int i = 1; i<routes.length;i++){
            if(routes[out][1]<routes[i][0]){
                num++;
                out = i;
            }
        }
        return num;
    }
}