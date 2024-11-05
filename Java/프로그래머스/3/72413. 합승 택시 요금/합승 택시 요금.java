import java.util.*;
class Solution {
    
    class Node{
        int edge;
        int distance;
        Node(int e,int d){
            edge = e;
            distance = d;}
    }

    void getSd(int n, int s,List<Node>[] graph, int[] sd){
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)->a.distance-b.distance);
        pq.addAll(graph[s]);
        pq.add(new Node(s,0));
        sd[s] = 0;
        
        int[] visited = new int[n+1];
        while(pq.size()!=0){
            Node node = pq.poll();
            //방문한 적 있으면 패스(이미 최단 경로 나옴)
            if(visited[node.edge]==1){continue;}
            visited[node.edge]=1; 
            for(Node adj : graph[node.edge]){
                //이미 최단 경로가 나온 인접 노드는 계산할 필요 없으니 pass
                if(visited[adj.edge]==1){continue;}
                //(출발 노드-경유 노드 거리 + 경유 노드-도착 노드까지 거리)를 현재 최단 길이와 비교/갱신
                int newDistacne = sd[node.edge] + adj.distance;
                sd[adj.edge] = Math.min(sd[adj.edge],newDistacne);
                pq.add(new Node(adj.edge,sd[adj.edge]));    
            }
        }return;
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        int[] sd = new int[n+1];
        int[] al = new int[n+1];
        int[] bl = new int[n+1];
        
        //초기화
        List<Node>[] graph = new List[n+1];
        int max = 500000000;
        for(int i=1;i<=n;i++){
            sd[i] = al[i] =bl[i] = max;
            graph[i] = new ArrayList<>();
        }
                
        Set<Integer> set = new HashSet<>();
        for(int[] fare : fares){
            graph[fare[0]].add(new Node(fare[1],fare[2]));
            graph[fare[1]].add(new Node(fare[0],fare[2]));
            //양방향 그래프
            set.add(fare[0]); set.add(fare[1]);
        }
        
        //출발점 s에서 모든 노드까지 최단 거리
        getSd(n,s,graph,sd);
        //출발점 a에서 모든 노드까지 거리 
        getSd(n,a,graph,al);
        //출발점 b에서 모든 노드까지 거리
        getSd(n,b,graph,bl);
        
        
        //합승 마지막 지점 x
        // x지점까지 최단 경로 + x지접에서 a까지 최단 경로(a지점에서 x지점까지의 경로와 같음) +  x 지점에서 b까지 최단 경로(b지점에서 x지점까지의 경로와 같음.)
        int min = Integer.MAX_VALUE;
        for(int i: set){
            min = Math.min(min,sd[i]+al[i]+bl[i]);
        }
        return min;
    }
}
