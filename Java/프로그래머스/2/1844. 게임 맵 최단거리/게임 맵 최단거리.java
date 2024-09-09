import java.util.*;
class Solution {    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
    
        int[][][] pre = new int[n][m][2];
        Queue<int[]> queue = new LinkedList<>();
        int[][] distance = new int[n][m];
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        int[] first = {0,0};
        queue.add(first);
        
        while(queue.size()!=0){
            int[] node = queue.poll();
            
            maps[node[0]][node[1]] = 0;
            
            int [] previousNode = pre[node[0]][node[1]];
            
            distance[node[0]][node[1]] = distance[previousNode[0]][previousNode[1]] + 1;
            
            if(node[0]==n-1 &&node[1]==m-1){break;}
            
            for(int i=0 ; i<4 ;i++){
                int newx = node[0] + dx[i];
                int newy = node[1] + dy[i];
                
                if(newx>=0&&newx<=n-1&& newy>=0&&newy<=m-1){
                    if(maps[newx][newy]==1){
                        int[] temp = {newx,newy};
                        queue.add(temp);
                        maps[newx][newy] = 0;
                        pre[temp[0]][temp[1]] = node;}
                }
            }
        }
        if(distance[n-1][m-1]==0){return -1;}
        return distance[n-1][m-1];
    }
}