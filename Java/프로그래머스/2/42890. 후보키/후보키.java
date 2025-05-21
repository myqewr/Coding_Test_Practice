import java.util.*;
class Solution {
    
    static List<Set<Integer>> result = new ArrayList<>();
    
    class Node{
        List<Integer> list = new ArrayList<>();
        Integer index;
        public Node(List<Integer>list,Integer index){
            this.list=list;
            this.index=index;
        }
    }
    
    public int solution(String[][] relation) {
        int size= relation[0].length;
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();
        for(int i=0;i<size;i++){
            queue.add(new Node(new ArrayList<>(),i));
        }
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int current = node.index;
            List<Integer> list = new ArrayList<>(node.list);
            list.add(current);
            if(func(list,relation)){
                result.add(new HashSet<>(list));answer++;continue;
            }
            for(int i=current+1;i<size;i++){
                queue.add(new Node(list,i));
            }
        }
        return answer;
    }
    
    Boolean func(List<Integer> list, String[][] relation){
        
        Set<Integer> newList = new HashSet<>(list);
        for(Set<Integer> check : result){
            if(newList.containsAll(check)) {return false;}
        }
        
        Set<String> set = new HashSet<>();
        
        for(int i=0;i<relation.length;i++){
            String string = "";
            for(int index : list){
                string+=relation[i][index];
            }
            set.add(string);
        }
        
        return set.size()==relation.length;
    
    }
}
