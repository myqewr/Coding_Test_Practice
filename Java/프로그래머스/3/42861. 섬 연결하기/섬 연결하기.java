import java.util.*;
class Solution {
    
    
    class Node{
        int weight;
        int adj;
        //생성자
        Node(int a, int w){
            this.adj = a;
            this.weight = w;
        }
    }
    static Map<Integer, List<Node>> map = new HashMap<>();
    public int solution(int n, int[][] costs) {
    
        //특정 노드의 인접 노드와 비용 정보 mapping 
        for(int i=0;i<n;i++){map.put(i, new ArrayList<Node>());}
        for(int[] cost: costs){
            map.get(cost[0]).add(new Node(cost[1],cost[2]));
            map.get(cost[1]).add(new Node(cost[0],cost[2]));
        }
        
        //프림 알고리즘
        Set<Integer> visit = new HashSet<>();
        visit.add(0);
        int dist = 0;
        while(visit.size()!=n){
            Node nextNode = getNextNode(visit);
            visit.add(nextNode.adj);
            dist+=nextNode.weight;
        }
        return dist; 
    }
    
    //현재 집합에서 뻗을 수 있는 간선 중 비용이 제일 작은 간선을 선택
    private Node getNextNode(Set<Integer> set){
        
        List<Node> nodeSet = new ArrayList<>();
        for(int node : set){nodeSet.addAll(map.get(node));}
        
        //간선 비용을 기준으로 간선 정렬
        Collections.sort(nodeSet, new Comparator<Node>(){
            public int compare(Node a, Node b){
                return a.weight-b.weight;}});
        
        //정렬된 간선 중 집합에 속하지 않는 비용이 가장 적은 간선 선택
        for(Node node: nodeSet){
            if(!set.contains(node.adj)){return node;}
        }
        return new Node(1,1); 
    }
}