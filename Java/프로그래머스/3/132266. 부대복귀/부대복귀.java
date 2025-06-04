import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        //최대 거리로 기본 세팅
        int[] distance = new int[n+1];
        for(int i=1;i<=n;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[destination] = 0;
        
        //양방향 그래프
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        // 인접 노드 세팅
        for(int[] road : roads){
            int s1 = road[0];
            int s2 = road[1];
            List<Integer> temp1 = map.getOrDefault(s1,new ArrayList<>());
            temp1.add(s2);
            map.put(s1,temp1);
            List<Integer> temp2 = map.getOrDefault(s2,new ArrayList<>());
            temp2.add(s1);
            map.put(s2,temp2);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
        (a,b) -> distance[a] - distance[b]);
        
        pq.addAll(map.get(destination));
        for(int i : map.get(destination)){
            distance[i]=1;
        }
        
        int[] visited=new int[n+1];
        while(!pq.isEmpty()){
            
            Integer now = pq.poll();
            if(visited[now]==1){continue;}
            visited[now] = 1;

            for(int next : map.get(now)){
                if(visited[next]==1){continue;}
                if(distance[next]> distance[now]+1){
                    distance[next] = distance[now]+1;
                }
                pq.add(next);
            }
        }
        
        int[] result = new int[sources.length];
        for(int i=0;i<sources.length;i++){
            int dist = distance[sources[i]];
            result[i] = dist==Integer.MAX_VALUE?-1:dist;
        }
    
        return result;
    }
}