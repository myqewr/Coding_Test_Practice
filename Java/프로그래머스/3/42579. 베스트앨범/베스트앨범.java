import java.util.*;
import java.util.Collections;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String,Integer> genAndNum = new HashMap<>();
        Map<String,Object> genAndSong= new HashMap<>();
        for(int i=0;i<genres.length;i++){
            String gen = genres[i];
            int currentNum = genAndNum.getOrDefault(gen,0);
            genAndNum.put(gen,currentNum+plays[i]);
            
            Map<Integer,Integer> songInfo = (HashMap<Integer,Integer>)genAndSong.getOrDefault(gen,new HashMap<Integer,Integer>());
            songInfo.put(i,plays[i]);
            genAndSong.put(gen,songInfo);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        List<String> topGenres = sortByKey(genAndNum);
        
        for(String gen : topGenres){
            
            List<Integer> values = sortByKey((HashMap<Integer,Integer>)genAndSong.get(gen));
            
            answer.add(values.get(0));
            if(values.size()>=2){answer.add(values.get(1));}
            
        }
        
        int answerArray[] = new int[answer.size()];
        for(int i=0;i<answer.size();i++){
            answerArray[i] = answer.get(i);
        }
        return answerArray;
        
        //Stream의 toArray는 Collection의 toArray보다 속도가 느리고, 메모리 소비가 많음.
        //결과값을 int형으로 반환해야하는 경우, Collection값이 Integer라면 int형으로 변환 필요. -> stream돌며 형변환 -> 결국엔 stream
        //따라서 그냥 반복문을 도는게 더 빠르다.
        //return answer.stream().mapToInt(i->i).toArray(); 
    }
    
    
    List sortByKey(Map map){
            
        List keySet = new ArrayList<>();
        keySet.addAll(map.keySet());
            
        Collections.sort(keySet,new Comparator(){
                
            public int compare(Object k1, Object k2){
                    
                Object v1 = map.get(k1);
                Object v2 = map.get(k2);
                    
                return ((Comparable)v2).compareTo(v1); 
            }});
            
        return keySet;
    }
}
 