import java.util.*;
class Solution {
                     //오,아래,왼,위
    static int[][] dirMap = {{0,1},{1,0},{0,-1},{-1,0}};
    static int len = 0;
    
    public int solution(int[][] board) {
        
        len = board.length;
        int[][][] dp = new int[len][len][4];
        for (int[][] is : dp) {
            for (int[] is2 : is) {
                is2[0] = Integer.MAX_VALUE-1;
                is2[1] = Integer.MAX_VALUE-1;
                is2[2] = Integer.MAX_VALUE-1;
                is2[3] = Integer.MAX_VALUE-1;
            }
        }
        
        dfs(0,false,0,1,board,dp,0);
        dfs(1,false,1,0,board,dp,0);
        
        int answer = 1000000;
        for(int i=0;i<4;i++){
            if(dp[len-1][len-1][i]!=0){answer = Math.min(answer,dp[len-1][len-1][i]);}
        }
        return answer;
    }
    
    
    public void dfs(int dir,Boolean corner,int x,int y,int[][] board, int[][][] dp,int pValue){        
        
        if(board[x][y]==1){return;}
        
        //해당 칸으로 도로를 연장할 경우 드는 비용 계산 -> 코너 비용 포함.
        int cost = corner==true?pValue+600:pValue+100;
        
        // 같은 방향으로 도로를 생성할 때, 해당 칸으로 들어오는 비용이 더 적은 경로가 존재하면, 탐색중인 경로는 더이상 탐색할 필요 없음. -> return
        if(dp[x][y][dir]<cost){return;}
            dp[x][y][dir] = cost;
        
        
        for(int d = 0; d<4;d++){
            //왔던 곳으로 다시 가지 않음.
            if(dir%2==d%2 && dir!=d){continue;}
            int dx = dirMap[d][0];
            int dy = dirMap[d][1];
            if(x+dx>=0&&x+dx<len&&y+dy>=0&&y+dy<len){
                if(board[x+dx][y+dy]==1){continue;}
                //대각선 방향으로 들어왔으면 코너 생성
                if(Math.abs(dir-d)%2==1){dfs(d,true,x+dx,y+dy,board,dp,cost);}
                else{dfs(d,false,x+dx,y+dy,board,dp,cost);}
            }
        }
        return ;  
    }
}