import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {   
        int MAX = 1000000000;
        int[] dp = new int[n+1];
        Arrays.fill(dp,MAX);
        dp[destination] = 0;
        int[] visit = new int[n+1];
        ArrayList<Integer>[] way = new ArrayList[n+1]; 
        for(int i=0;i<=n;i++){
            way[i] = new ArrayList<Integer>();
        }
        
        for(int[] road : roads){
            way[road[0]].add(road[1]);
            way[road[1]].add(road[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(destination);
        
        while(queue.size()!=0){
            int node = queue.poll();
            visit[node] = 1;
            for(Integer adj : way[node]){
                if(visit[adj]==1){continue;}
                dp[adj] = Math.min(dp[adj], dp[node]+1);
                queue.add(adj);
            }
        }
        
        int[] answer = new int[sources.length];
        for(int i=0;i<sources.length;i++){
            answer[i] = dp[sources[i]]==MAX?-1:dp[sources[i]];
        }

        return answer;
    }
}