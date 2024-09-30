import java.util.*;
class Solution {
    public int solution(String s) {
        int min = 10000;
        for(int i=0; i<=s.length()/2;i++){
            Map<Integer,String> map = new HashMap<>();
            
            int lastIndex = 0;
            for(int j=0 ; j+i+1<=s.length(); j=j+i+1){
                String slice = s.substring(j,j+i+1);
                if(map.containsKey(j-i-1)){
                    if(map.get(j-i-1).contains(slice)){
                        if(map.get(j-i-1).length()==slice.length()){
                            String value = "2" + slice;
                            map.put(j, value);
                            map.remove(j-i-1);
                        }
                        else{
                            Integer num = Integer.valueOf(map.get(j-i-1).substring(0,map.get(j-i-1).length()-slice.length()));
                            num+=1;
                            String value = String.valueOf(num)+slice;
                            map.put(j,value);
                            map.remove(j-i-1);}
                    }
                    else{
                        map.put(j,slice);
                    }
                }
                else{map.put(j,slice);}
                
                lastIndex = j + i+1;
            }
            
            String result = "";
            for(Integer key: map.keySet()){
                result += map.get(key);
            }
            int len = result.length() +s.length()-lastIndex; 
            min = Math.min(min,len);
        }
        int answer = min;
        return answer;
    }
}