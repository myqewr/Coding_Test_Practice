import java.util.*;


class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
    Map<Integer,Integer> reserveList = new HashMap<>();
    Map<Integer,Integer> reserveList2 = new HashMap<>();   
    Arrays.stream(reserve).forEach(r->{reserveList.put(r,r); reserveList2.put(r,r);});
     
    List<Integer> lost2 = new ArrayList();
    
    for(int l:lost){
        if(!reserveList.containsKey(l)){
            lost2.add(l);
        }
        reserveList.remove(l);
        reserveList2.remove(l);
    }      
    
    int[] numList = {0,0};

        
    for(int ln : lost2){
        if(reserveList.containsKey(ln-1)){
            reserveList.remove(ln-1);
            numList[0]=numList[0]+1;
        }
        
        else if(reserveList.containsKey(ln+1)){
            reserveList.remove(ln+1);
            numList[0]=numList[0]+1;
        } 
    }
    
    for(int ln : lost2){
        if(reserveList2.containsKey(ln+1)){
            reserveList2.remove(ln+1);
            numList[1]=numList[1]+1;
        }
        
        else if(reserveList2.containsKey(ln-1)){
            reserveList2.remove(ln-1);
            numList[1]=numList[1]+1;
        } 
    }
    int answer = Arrays.stream(numList).max().getAsInt() + n-lost2.size() ;
    return answer;
    }
}