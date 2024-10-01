import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        
        List<Integer> listCourse = new ArrayList<>();
        Arrays.stream(course).forEach(c->listCourse.add(c));
        
        Map<Integer,Map<String, Integer>> numMap = new HashMap<>();
        for(int c : course){
            Map<String, Integer> mapTemp = new HashMap<>();
            numMap.put(c,mapTemp);
        }
        
        for(String order : orders){
            
            List<String> orderString = new ArrayList<>();
            Map<String,Integer> indexMap = new HashMap<>();
            char[] orderChar = order.toCharArray();
            Arrays.sort(orderChar);
            Queue<String[]> queue = new LinkedList<>();
            for(int i=0 ; i<order.length();i++){
                String value = String.valueOf(orderChar[i]);
                orderString.add(value);
                indexMap.put(value,i);
                String[] queueValue = {value,""};
                queue.add(queueValue);
            }
            while(queue.size()!=0){
                String[] s = queue.poll();
                String currentString = s[1] + s[0];
                int len = currentString.length();
                if(listCourse.contains(len)){
                    Map<String, Integer> map = numMap.get(len);
                    if(map.containsKey(currentString)){
                        int numOfOrder = map.get(currentString)+1;
                        map.replace(currentString, numOfOrder);
                    }
                    else{
                        map.put(currentString,1);
                    }
                }
                for(int i = indexMap.get(s[0])+1;i<order.length();i++){
                    String value = orderString.get(i);
                    String[] queueValue = {value, currentString};
                    queue.add(queueValue);
                } 
            }
        }
        
        
        
        List<String> answer = new ArrayList<>();
        for(Integer num : course){
            Map<String,Integer> map = numMap.get(num);
            if(map.size()==0){break;}
            int max = map.values().stream().max((a,b)->a-b).get();
            if(max== 1){break;}
            for(String value : map.keySet()){
                if(map.get(value)==max){
                    answer.add(value);
                }
            }
        }
        String[] answerReal = answer.toArray(new String[answer.size()]);
        Arrays.sort(answerReal);
        return answerReal;
    }
}