import java.util.*;
class Solution {
    
    public List<List<String>> dfs(List<List<String>> result,List<String> way,String[] current,List<String[]> tickets, int num){
        
        if(tickets.size()==0){
            result.add(way);
            return result;
        }
        
        for(String[] ticket:tickets){
            if(current[1].equals(ticket[0])){
                List<String[]> newTickets = new ArrayList<>(tickets);
                newTickets.remove(ticket);
                List<String> newWay = new ArrayList<>(way);
                newWay.add(ticket[1]);
                result = dfs(result,newWay,ticket,newTickets,num);
                if(result.size()>0){
                    break;  
                }
            }
        }
        return result;
    }
    
    public List<String[]> sort(String[][] tickets){
        String[] stringList = new String[tickets.length];
        Map<String,Integer> mapTicket = new HashMap<>();
        
        for(int i=0;i<tickets.length;i++){
            String ticketString = tickets[i][0]+tickets[i][1];
            stringList[i] = ticketString;
            mapTicket.put(ticketString,i);
        }
        Arrays.sort(stringList);
        
        List<String[]> newTickets = new ArrayList<>();
        for(String ticket : stringList){
            int num = mapTicket.get(ticket);
            newTickets.add(tickets[num]);
        }
        
        return newTickets;
        
    }
    
    public String[] solution(String[][] tickets) {
        
        List<String[]> sortedTickets = sort(tickets);
        List<String> answer = new ArrayList<>();

        List<String[]> icnList = new ArrayList<>();
        sortedTickets.forEach(t->{
            if(t[0].equals("ICN")){
                icnList.add(t);}
        });
        
        for(String[] ticket:icnList){
            List<List<String>> result = new ArrayList<>();
            List<String> way = new ArrayList<>();
            way.add(ticket[0]); way.add(ticket[1]);
            
            List<String[]> newTickets = new ArrayList<>(sortedTickets);
            newTickets.remove(ticket);
            
            result = dfs(result,way,ticket,newTickets,tickets.length);
            
            if(result.size()>0){
                answer = result.get(0);
                break;
            }                
        }
        return answer.toArray(new String[tickets.length+1]);
    }
}
