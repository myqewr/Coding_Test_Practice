import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        
        ArrayList<Integer>[] gr = new ArrayList[n+1];
        ArrayList<Integer> visited = new ArrayList<>();
        int[] distance = new int[n+1];
        
        for(int i=1;i<=n;i++) gr[i] = new ArrayList<>();
        
        for(int[] ed : edge) {
            gr[ed[0]].add(ed[1]);
            gr[ed[1]].add(ed[0]);
        }
        
        ArrayList<Integer> nextNode = new ArrayList<>();
        Queue<Integer> currentNode = new LinkedList<>();
        
        currentNode.add(1);
        
        for(int i=0;i<=n;i++){
            if(currentNode.size()==0){break;}
            while(currentNode.size()!=0){
                int node = currentNode.poll();
                if(visited.contains(node)){continue;}
                nextNode.addAll(gr[node]);
                visited.add(node);
                distance[i]++;
            }
            currentNode.addAll(nextNode);
            nextNode.clear();
        }
        
        
        for(int i = n;i>=1;i--){
            if(distance[i]!=0){return distance[i];}
        }
        return 0;
        
    }
}