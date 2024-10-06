
import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int map[][] = new int[n+1][m+1];
        for(int[] puddle: puddles){
            map[puddle[1]][puddle[0]] =-1;
        }
        for(int i = 1; i<n+1;i++){
            for(int j = 1;j<m+1;j++){
                if(i==1&&j==1){
                    map[1][1]=1;
                    continue;}
                //현재 위치가 물웅덩이가 아니고
                if(map[i][j]!=-1){
                    int up = map[i-1][j]==-1?0:map[i-1][j]; 
                    int left = map[i][j-1]==-1?0:map[i][j-1];
                    map[i][j] = (up+left)%1000000007;
                }
            }   
        }
        
        int answer = map[n][m];
        return answer;
    }
}
