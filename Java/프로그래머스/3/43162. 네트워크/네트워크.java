class Solution {
    public int solution(int n, int[][] computers) {
        
        int[] visited = new int[n];
        int num= 0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){num++;dfs(visited,i,computers);}
        }
        
        return num;
    }
    
    private void dfs(int[]visited,int node, int[][]computers){
        int[] connected =  computers[node];
        visited[node]=1;
        for(int i=0;i<connected.length;i++){
            if(connected[i]==1 && visited[i]==0){
                dfs(visited,i,computers);
            }
        }
        return ;
    }
}