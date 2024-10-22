import java.util.*;
class Solution {
    
    
    class Node{
        int weight;
        int adj;
        Node(int a, int w){
            this.adj = a;
            this.weight = w;
        }
    }
    static Map<Integer, List<Node>> map = new HashMap<>();
    public int solution(int n, int[][] costs) {
    
        for(int i=0;i<n;i++){map.put(i, new ArrayList<Node>());}
        for(int[] cost: costs){
            map.get(cost[0]).add(new Node(cost[1],cost[2]));
            map.get(cost[1]).add(new Node(cost[0],cost[2]));
        }
        
        Set<Integer> visit = new HashSet<>();
        visit.add(0);
        int dist = 0;
        while(visit.size()!=n){
            Node nextNode = getNextNode(visit);
            System.out.println(nextNode.weight);
            visit.add(nextNode.adj);
            dist+=nextNode.weight;
        }
        
        return dist;
        
    }
    
    private Node getNextNode(Set<Integer> set){
        
        List<Node> nodeSet = new ArrayList<>();
        for(int node : set){
            nodeSet.addAll(map.get(node));
        }
        Collections.sort(nodeSet, new Comparator(){
            public int compare(Object a, Object b){
                Node nodeA = (Node)a;
                Node nodeB = (Node)b;
                return ((Comparable)(nodeA.weight)).compareTo(nodeB.weight);
            }
        });
        
        Node answer = new Node(1,1);
        for(Node node: nodeSet){
            if(!set.contains(node.adj)){answer=node;break;}
        }
        return answer;
        
        
        
    }
}