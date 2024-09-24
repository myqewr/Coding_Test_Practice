import java.util.*;
class Solution {
    public int solution(String[][] relation) {
        
        Queue<List<Integer>> queue = new LinkedList<>();
        
        List<List<Integer>> answer= new ArrayList<>();
        
        for(int i=0;i<relation[0].length;i++){
            List<Integer> visit = new ArrayList();
            visit.add(i);
            queue.add(visit);
        }
        int sum = 0;
        
        while(queue.size()!=0){
            
            List<Integer> visit = queue.poll();
            
            int lastIndex = visit.size()-1;
            int last = visit.get(lastIndex);
            
            Map<List<String>,Integer> valuesList = new HashMap<>();
            
            for(String[] tuple : relation){
                List<String> values = new ArrayList<>();
                for(Integer col : visit){
                    values.add(tuple[col]);
                }
                valuesList.put(values,1);
            }
            //유일성 만족함.
            if(valuesList.keySet().size()==relation.length){
                Boolean check = true;
                for(List<Integer> temp : answer){
                    if(visit.containsAll(temp)){
                        check = false;
                        break;
                    }
                }
                if(check){answer.add(visit);}
            }
            else {
                for(int i=last+1;i<relation[0].length;i++){
                List<Integer> newVisit = new ArrayList<>(visit);
                newVisit.add(i);
                queue.add(newVisit);
                }
            }
        }
        return answer.size();
    }
}