import java.util.*;
class Solution {
    
    public Boolean check(String a, String b){
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        
        int different = 0;
        for(int i=0;i<aChar.length;i++){
            if(aChar[i]!=bChar[i]){different+=1;}
        }
        if(different==1){return true;}
        return false;
        
    }
    
    public int solution(String begin, String target, String[] words) {
        
        Map<String,Boolean> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Map<String,Integer> distance = new HashMap<>();
        Map<String,String> pre = new HashMap<>();
        
        queue.add(begin);
        distance.put(begin,0);
        distance.put(target,0);
        pre.put(begin,begin);
        
        while(queue.size()!=0){
            String word = queue.poll();
            
            for(String wordDic : words){
                //방문한적 없고
                if(!visited.containsKey(wordDic)){
                    //변환 가능하다면
                    if(check(wordDic,word)){
                        queue.add(wordDic);
                        pre.put(wordDic,word);
                        visited.put(wordDic,true);
                        int beforeDistance = distance.get(pre.get(wordDic));
                        distance.put(wordDic,beforeDistance+1);
                        if(wordDic ==target){break;}
                    }
                }     
            } 
        }
        return distance.get(target);
    }
}