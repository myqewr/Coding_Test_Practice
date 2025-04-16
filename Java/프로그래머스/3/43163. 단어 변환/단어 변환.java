import java.util.*;
import java.util.stream.Collectors;
class Solution {
    
    class Node{
        int depth;
        String text;
        List<String> candidates;
        
        Node(int depth,String text,List<String> candidates){
            this.depth = depth;
            this.text = text;
            this.candidates = candidates;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        Queue<Node> queue = new LinkedList();
        
        List<String> candidates = Arrays
            .stream(words)
            .filter(w -> check(begin,w))
            .collect(Collectors.toList());
        
        System.out.println(candidates);
        
        for(String candidate : candidates){
            List<String> newCandidates = new ArrayList<>(Arrays.asList(words));
            newCandidates.remove(candidate);
            queue.add(new Node(1,candidate,newCandidates));
        }
        
        while(!queue.isEmpty()){
            
            Node node = queue.poll();
            
            //완성된 경우
            if(node.text.equals(target)){
                return node.depth;
            }
            //완성되지 않은 경우
            node.candidates
                .stream()
                .filter(c -> check(node.text,c))
                .forEach(c-> {
                    List<String> nc3 = new ArrayList<>(node.candidates);
                    nc3.remove(node.text);
                    queue.add(new Node(node.depth+1,c,nc3));
             }) ; 
        }
                
        int answer = 0;
        return answer;
    }
    
    public Boolean check(String target, String subject){
        
        char[] t = target.toCharArray();
        char[] s = subject.toCharArray();
        
        int num =0;
        for(int i=0;i<t.length;i++){
            if(t[i]!=s[i]){num++;}
        }

        if(num==1){return true;}
        else{return false;}
        
    }
}