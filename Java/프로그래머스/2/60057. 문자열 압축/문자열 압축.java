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
                        String len = map.get(j-i-1).substring(0,map.get(j-i-1).length()-slice.length());
                        Integer num = len.equals("")? 1: Integer.valueOf(len);
                        num+=1;
                        String value = String.valueOf(num)+slice;
                        map.put(j,value);
                        map.remove(j-i-1);}
                    else{
                        map.put(j,slice);}
                }
                else{map.put(j,slice);}
                lastIndex = j + i + 1;
            }
            int len = 0;
            for(Integer key: map.keySet()){
                len += map.get(key).length();
            }
            len += s.length()-lastIndex; 
            min = Math.min(min,len);
        }
        int answer = min;
        return answer;
    }
}