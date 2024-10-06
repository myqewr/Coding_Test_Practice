import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int map[][] = new int[n][m];
        for(int[] puddle: puddles){
            map[puddle[1]-1][puddle[0]-1] = 1;
        }
        
        int num[][] = new int[n][m];
        int dist[][] = new int[n][m];
        
        for(int i = 0; i<n;i++){
            for(int j = 0;j<m;j++){
                if(i==0&&j==0){
                    dist[0][0]=1;
                    num[0][0]=1;
                    continue;}
                //현재 위치가 물웅덩이가 아니고
                if(map[i][j]!=1){
                    int up = i==0?100000:dist[i-1][j]; 
                    int left = j==0? 100000: dist[i][j-1];

                    if(left>up){
                        dist[i][j] = up+1;
                        num[i][j] = num[i-1][j];
                    }
                    else if(left<up){
                        dist[i][j] = left+1;
                        num[i][j] = num[i][j-1];
                    }
                    else{
                        if(left!=100000){
                            dist[i][j] = up+1;
                            num[i][j] = (num[i-1][j]+num[i][j-1])%1000000007;
                        }
                        else{dist[i][j] = 100000;}
                    }
                }
                else{dist[i][j] = 100000;}
            }   
        }
        int answer = num[n-1][m-1];
        return answer;
    }
}