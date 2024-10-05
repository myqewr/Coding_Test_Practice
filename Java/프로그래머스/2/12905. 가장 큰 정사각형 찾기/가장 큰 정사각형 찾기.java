import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        
        //dp에는 (i,j)를 정사각형의 오른쪽 아래 꼭지점으로 했을때 만들 수 있는 최대 사각형의 넓이를 기록.
        // 정사각형은 왼쪽 정사각형 + 오른쪽 위 정사각형 + 대각선 정사각형으로 만들어진다는 아이디어가 핵심
        
        int m = board.length;
        int n = board[0].length;
        int[][] dp = new int[m][n]; 
        
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //0번 행 또는 0번 열에 위치한 사각형일 경우, 만들 수 있는 정사각형의 최대 크기가 1.
                if(board[i][j]==1){
                    if(i==0 || j==0){
                        dp[i][j] = 1;
                    }
                    else{
                        int value = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                        dp[i][j] = value;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}