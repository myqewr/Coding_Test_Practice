import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    
    public Integer recursion(Map<String,String> keyMap,Map<String, List<Integer>> infoMap, String[] askList, String currentKey, Integer num, Integer point){
        
        int peopleNum = 0;
            
        if(num==4){
            
            if(!infoMap.containsKey(currentKey)){
                return 0;
            }
            List<Integer> pointList = infoMap.get(currentKey);
            
            for(int i=0;i<pointList.size();i++){
                if(pointList.get(i)>=point){return pointList.size()-i;}
            }
        }
        else{
            
            if(askList[num].equals("-")){
                peopleNum+=recursion(keyMap,infoMap,askList, currentKey+"0",num+1,point);
                peopleNum+=recursion(keyMap,infoMap,askList, currentKey+"1",num+1,point);
                if(num==0){
                peopleNum+=recursion(keyMap,infoMap,askList, currentKey+"2",num+1,point);
                }
            }
            else{
                String key = keyMap.get(askList[num]);
                peopleNum=recursion(keyMap,infoMap,askList, currentKey+key,num+1,point);
            }
            
        }
        return peopleNum;
    }
    
    
    public int[] solution(String[] info, String[] query) {
        
       Map<String,String> keyMap = new HashMap<>();
        keyMap.put("cpp","0");
        keyMap.put("java","1");
        keyMap.put("python","2");
        keyMap.put("backend","0");
        keyMap.put("frontend","1");
        keyMap.put("junior","0");
        keyMap.put("senior","1");
        keyMap.put("chicken","0");
        keyMap.put("pizza","1");
        
        Map<String, List<Integer>> infoMap = new HashMap<>();
        
        for(String indi : info){
            String[] infoList = indi.split(" ",5);
            String keyValue = "";
            for(int i =0; i<4 ; i++){
                keyValue+=keyMap.get(infoList[i]);
            }
            
            if(infoMap.containsKey(keyValue)){
                List<Integer> pointList = infoMap.get(keyValue);
    
                pointList.add(Integer.valueOf(infoList[4]));
                Collections.sort(pointList);
                infoMap.replace(keyValue, pointList);
            }
            else{
                
                List<Integer> pointList = new ArrayList<>();
                pointList.add(Integer.valueOf(infoList[4]));
                infoMap.put(keyValue, pointList);

            }
        }
        
        List<Integer> answer = new ArrayList<>();
        
        for(String ask : query){
            String[] askList = ask.split(" and ",4);
            String queryKey = "";
            String[] temp = askList[3].split(" ");
            askList[3] = temp[0];
            int point = Integer.valueOf(temp[1]);
            
            int numberOfPeople = recursion(keyMap,infoMap,askList,queryKey,0,point);
            answer.add(numberOfPeople);
        }
        
        return answer.stream().mapToInt(i->i).toArray();
        
    }
    
}