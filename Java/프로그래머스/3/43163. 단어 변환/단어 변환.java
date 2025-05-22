import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        class Node{
            int deepth;
            String value;
            List<String> candidates;
            public Node(int deepth,String value, List<String> candidates){
                this.deepth = deepth;
                this.value = value;
                this.candidates = candidates;
            }
        }
        Queue<Node> queue = new LinkedList<>();
    
        queue.add(new Node(0,begin,Arrays.asList(words)));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.value.equals(target)){
                return node.deepth;
            }
            
            for(String candidate: node.candidates){
                if(func(node.value,candidate)){
                    List<String> newCandidates = new ArrayList<>(node.candidates);
                    newCandidates.remove(candidate);
                    queue.add(new Node(node.deepth+1,candidate,newCandidates));
                }
            }
            
        }
        
        int answer = 0;
        return answer;
    }
    
    public Boolean func(String s1, String s2){
        int dif = 0;
        
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){dif++;}
        }
        return dif==1;
    }
}