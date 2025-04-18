class Solution {
    public int solution(int[][] triangle) {
        int depth = triangle.length-1;
        
        int[][] dp = new int[triangle.length][triangle.length];
    
        //초기값 세팅
        int x=0;
        for(int value : triangle[depth]){
            dp[depth][x] = value;
            x++;
        }
        
        for(int i= depth-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j] = Math.max(dp[i+1][j],dp[i+1][j+1])+triangle[i][j];
            }
        }
        
        return dp[0][0];
    }
        
        
}