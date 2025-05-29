class Solution {
    public int solution(int sticker[]) {
        
        if(sticker.length==1){
            return sticker[0];
        }
        
        if(sticker.length==2){
            return Math.max(sticker[0],sticker[1]);
        }
        
        int dp[] = new int[sticker.length];
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        // 1번 스티커를 선택하는 경우
        int max = 0;
        
        for(int i=2;i<sticker.length-1;i++){
            if(sticker[i]+dp[i-2] <dp[i-1]){
                dp[i] = dp[i-1];
            }
            else{dp[i] = sticker[i] + dp[i-2];} 
            if(max < dp[i]) max = dp[i];
        }
        
        // 1번 스티커를 선택하지 않는 경우
        
        int dp2[] = new int[sticker.length];
        dp2[0] = 0;
        dp2[1] = sticker[1] ; 
        for(int i=2;i<sticker.length;i++){
            if(sticker[i]+dp2[i-2] <dp2[i-1]){
                dp2[i] = dp2[i-1];
            }
            else{dp2[i] = sticker[i] + dp2[i-2];} 
            if(max < dp2[i]) max = dp2[i];
        }
    
        return max;
    }
}