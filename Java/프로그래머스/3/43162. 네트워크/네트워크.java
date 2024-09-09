class Solution {
    
    public int[] dfs(int n, int[][]computers, int nth, int[] isChecked){
        isChecked[nth]=1;
        for(int i=0 ;i<n;i++){
            if(i!=nth && computers[nth][i]==1 &&isChecked[i]==0){
                isChecked = dfs(n,computers,i,isChecked);
            }
        }
        return isChecked;
    }
    
    
    public int solution(int n, int[][] computers) {
        int[] isChecked = new int[n];
        int answer = 0;
        for(int i=0;i<n;i++){
            if(isChecked[i]==0){
                isChecked = dfs(n,computers,i,isChecked);
                answer +=1;
            }
        }
        return answer;
    }
}