import java.util.*;

class Solution {
    
    
    public String[] solution(String[] players, String[] callings) {
        
        Map<String,Integer> order = new HashMap<>();
        
        for(int i=0; i<players.length;i++){
            order.put(players[i],i);
        }
        
        for(String player : callings){
            //현재 호출된 선수의 등수
            int nth = order.get(player); 
            
            //호출된 선수의 앞 선수 이름
            String front_player = players[nth-1];
            
            //두 선수의 순서 변경
            players[nth] = front_player;
            players[nth-1] = player;
            
            //두 선수의 순서 변경 
            order.replace(player, nth-1);
            order.replace(front_player, nth);
        }
        
        return players;
    }
}