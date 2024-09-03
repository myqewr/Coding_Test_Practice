import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {

        Map<String,Map<String,Integer>> aGiveToB = new HashMap<>();
        Map<String,Integer> giftNum = new HashMap<>();
        
        for(String friend1 : friends){
            
            Map<String,Integer> give = new HashMap<>();
            giftNum.put(friend1,0);
            
            for(String friend2 : friends){
                give.put(friend2,0);
            }
            aGiveToB.put(friend1,give);
        }
        
        for(String gift : gifts){
            String a = gift.split(" ")[0];
            String b = gift.split(" ")[1];
            
            //주고 받은 선물 정리
            int numOfPresents = aGiveToB.get(a).get(b) ;
            Map<String,Integer> temp = aGiveToB.get(a) ; 
            temp.replace(b,numOfPresents+1);
            aGiveToB.replace(a,temp);
            
            //선물 지수 정리
            int aNum = giftNum.get(a);
            int bNum = giftNum.get(b);
            giftNum.replace(a,aNum+1);
            giftNum.replace(b,bNum-1);
        }
        
        int[] giftresult = new int[friends.length];
        for(int i=0;i<friends.length;i++){
            for(int j = i+1;j<friends.length;j++){
                int aGiveB = aGiveToB.get(friends[i]).get(friends[j]);
                int bGiveA = aGiveToB.get(friends[j]).get(friends[i]);
                if(aGiveB > bGiveA){giftresult[i]++;}
                else if(aGiveB < bGiveA){giftresult[j]++;}
                else{
                    if(giftNum.get(friends[i])>giftNum.get(friends[j])){giftresult[i]++;}
                    else if(giftNum.get(friends[i])<giftNum.get(friends[j])){giftresult[j]++;}
                    }
            }
        }
        return Arrays.stream(giftresult).max().getAsInt();
        
 
    }
}