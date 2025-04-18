import java.util.*;
class Solution {
    public int solution(int n, int[][] edges) {
        Map<Integer,List<Integer>> graph = new HashMap<>();//양방향 그래프
        
        int[] status = new int[n+1] ;
        for(int i=2;i<=n;i++){
            status[i] = Integer.MAX_VALUE;
        }
        
        for(int[] edge : edges){
            List<Integer> adj1 =  graph.getOrDefault(edge[0],new ArrayList<>());
            adj1.add(edge[1]);
            graph.put(edge[0],adj1);
            List<Integer> adj2 =  graph.getOrDefault(edge[1],new ArrayList<>());
            adj2.add(edge[0]);
            graph.put(edge[1],adj2);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(p -> status[p]));
        
       
        //1의 인접 노드는 초기화, 간선 수 1로 설정;
        for(int adj : graph.get(1)){
            status[adj] = 1;
            pq.add(adj);
        }
        
        int[] visited = new int[n+1];
        visited[1] =1;
        while(!pq.isEmpty()){
            Integer node = pq.poll();
            
            if(visited[node]==1){continue;}
            
            visited[node] = 1;
            
            List<Integer> children = graph.get(node);
            
            for(int child :  children){
                if(visited[child]==1){continue;}
                pq.add(child);
                if(status[child] > status[node] +1){
                    status[child] = status[node]+1;
            
                }
            }
        }
        
    
        
        int max = Arrays.stream(status).max().getAsInt();
        
        int answer =0;
        for(int i=2;i<=n;i++){
            if(max==status[i]){answer++;}
        }
        
        return answer;
    }
}

//정점으로부터 모든 경로의 최단 경로 구하기 
