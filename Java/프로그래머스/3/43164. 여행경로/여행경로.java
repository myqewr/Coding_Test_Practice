import java.util.*;
class Solution {
    
    public static int size ;
    public static Boolean isCompleted = false;
    public String[] solution(String[][] array){
        
        size = array.length;
        
        List<String[]> tickets = new ArrayList<>();
        Arrays.sort(array,(a,b)-> (a[0]+a[1]).compareToIgnoreCase((b[0]+b[1])));
        
        List<String[]> icnList = new ArrayList<>();
        for(String[] arr : array){
            if(arr[0].equals("ICN")){icnList.add(arr);}
            tickets.add(arr);
        }
        
        
        for(String[] icn : icnList){
            List<String> result = bfs(icn[0],List.of("ICN"),tickets);
            if(result.size()==size+1){
                return result.toArray(new String[0]);
            }
        }
        
        String[] answer = {};
        return answer;
    }
    
    public List<String> bfs(String from, List<String> way,List<String[]> candidates){
        
        if(isCompleted==true){return List.of();}
        
        if(way.size()==size+1){
            isCompleted = true;
            return way;
        }
        List<String> result = new ArrayList<>();
        for(String[] candidate : candidates){
            if(candidate[0].equals(from)){ //방문 가능하면
                List<String> newWay = new ArrayList<>(way);
                newWay.add(candidate[1]);
                List<String[]> newCandidates = new ArrayList<>(candidates);
                newCandidates.remove(candidate);
                result.addAll(bfs(candidate[1],newWay,newCandidates));
            }   
        }
        return result;
    }
}