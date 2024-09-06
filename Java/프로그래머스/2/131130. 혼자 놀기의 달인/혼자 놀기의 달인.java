import java.util.*;

class Solution {
    public int solution( int[] cards) {
        
        
        Map<Integer,List<Integer>> choices = new HashMap<>();
        
        List<Integer> cardsTemp = new ArrayList<>();
        cardsTemp.add(0);
        for(int card: cards){
            cardsTemp.add(card);
        }
        int max = 0;
        
        List<Integer> originalCardsTemp = new ArrayList<>(cardsTemp);
        
        for(int i=1;i<=cards.length;i++){
            List<Integer> result = new ArrayList<>();
            int firstBoxNum = 0;
            int secondBoxNum = 0;
            
            ///첫번째 상자
            if(!choices.containsKey(i)){
                int nextLocation = i;
                
                while(cardsTemp.get(nextLocation)!=0){
                    int temp = cardsTemp.get(nextLocation);
                    result.add(temp);
                    cardsTemp.set(nextLocation,0);
                    nextLocation = temp;
                }
                choices.put(i,result);
            }
            else{
                for(int c : choices.get(i)){
                    cardsTemp.set((int)c,0);}
            }
            firstBoxNum = choices.get(i).size();
            
            List<Integer> cardsTemp2 = new ArrayList<>(cardsTemp);
            
            ///두번째 박스
            
            for(int j = 1;j<=cards.length;j++){
                
                if(cardsTemp.get(j)==0){
                    continue;
                }
                List<Integer> result2 = new ArrayList<>();
                if(!choices.containsKey(j)){
                    int nextLocation = j;
                
                    while(cardsTemp.get(nextLocation)!=0){
                        int temp = cardsTemp.get(nextLocation);
                        result2.add(temp);
                        cardsTemp.set(nextLocation,0);
                        nextLocation = temp;
                    }
                    choices.put(j,result2);
                }
                secondBoxNum = choices.get(j).size();
            
                max =Math.max(max, firstBoxNum * secondBoxNum);
                cardsTemp = new ArrayList<>(cardsTemp2); 
            }
            cardsTemp = new ArrayList<>(originalCardsTemp);
        }
        int answer = max;
        return answer;
    }
}
    

    
    

    
    
    