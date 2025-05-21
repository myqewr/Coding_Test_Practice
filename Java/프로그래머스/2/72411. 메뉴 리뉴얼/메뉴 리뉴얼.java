import java.util.*;
class Solution {
    
    class Node{
        int index;
        int deepth;
        Set<String> set ;
        public Node(int index,int deepth,Set<String>set){
            this.index = index;
            this.deepth = deepth;
            this.set = set;
        }
    }
    
    public String[] solution(String[] orders, int[] courses) {
        List<Integer> course = new ArrayList<>();
        for(int c: courses){course.add(c);}
        Map<Set<String>,Integer> map = new HashMap<>();
        List<Set<String>> orderSet = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(String order : orders){
            List<String> stringList =  Arrays.asList(order.split(""));
            set.addAll(stringList);
            orderSet.add(new HashSet<>(stringList));
        }
        List<String> chars  = new ArrayList<>(set);
        Collections.sort(chars);
        Queue<Node> queue = new LinkedList<>();

        for(int i=0;i<chars.size();i++){
            Set<String> sett = new HashSet<>();
            sett.add(chars.get(i));
            queue.add(new Node(i,1,sett));
        }
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(course.contains(node.deepth)){
                for(Set<String> order : orderSet){
                if(order.containsAll(node.set)){
                    int num =  map.getOrDefault(node.set,0);
                    map.put(node.set,num+1);
                    }
                }
            }
            
            if(!map.containsKey(node.set)&&course.contains(node.deepth)){continue;}
            for(int i=node.index+1;i<chars.size();i++){
                Set<String> newSet = new HashSet<>(node.set);
                newSet.add(chars.get(i));
                queue.add(new Node(i,node.deepth+1,newSet));
            }
            
        }
        
        Map<Integer,Integer> maxMap = new HashMap<>();
        for(Set<String> key : map.keySet()){
            if(map.get(key)>=2){
                int v = maxMap.getOrDefault(key.size(),0);
                maxMap.put(key.size(),Math.max(v,map.get(key)));
            } 
        }
        
        List<String> result = new ArrayList<>();
        for(Set<String> key : map.keySet()){
            if(map.get(key)==maxMap.get(key.size())){
                List<String> temp = new ArrayList<>(key);
                Collections.sort(temp);
                result.add(String.join("",temp));
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}