import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        
        //course를 list로 변환
        List<Integer> listCourse = new ArrayList<>();
        Arrays.stream(course).forEach(c->listCourse.add(c));
        
        //코스 개수 , 메뉴 구성 , 주문 횟수
        Map<Integer,Map<String, Integer>> numMap = new HashMap<>();
        for(int c : course){
            Map<String, Integer> mapTemp = new HashMap<>();
            numMap.put(c,mapTemp);
        }
        
        for(String order : orders){

            Map<String,Integer> indexMap = new HashMap<>();
            
            //{현재 노드, 현재 노드에 도착하기 까지 누적된 문자열}
            Queue<String[]> queue = new LinkedList<>();
            
            //메뉴 문자열을 정렬하고, 문자 list로 변환
            char[] orderChar = order.toCharArray();
            Arrays.sort(orderChar);
            List<String> orderString = new ArrayList<>();
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
                
                //문제에서 요구하는 코스 메뉴 구성 개수일 경우에만 로직 진행
                if(listCourse.contains(len)){
                    Map<String, Integer> map = numMap.get(len);
                    
                    // 같은 조합의 코스 구성 주문 횟수 +1
                    if(map.containsKey(currentString)){
                        int numOfOrder = map.get(currentString)+1;
                        map.replace(currentString, numOfOrder);
                    }
                    //한번도 주문된적 없으면 주문횟수 1로 초기화
                    else{
                        map.put(currentString,1);
                    }
                }
                // queue에 삽입 ->  {child node , 현재까지 누적된 코스 구성}
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
            
            //한번만 주문된거면 구성에 포함 x
            if(max== 1){break;}
            for(String value : map.keySet()){
                if(map.get(value)==max){
                    answer.add(value);
                }
            }
        }
        String[] answerArray = answer.toArray(new String[answer.size()]);
        Arrays.sort(answerArray);
        return answerArray;
    }
}