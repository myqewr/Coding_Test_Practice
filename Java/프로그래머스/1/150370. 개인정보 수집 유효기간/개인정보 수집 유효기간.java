import java.util.*;

class Solution {
    
    public Boolean expCheck(String today, String date, Integer exp){
        
        List<Integer> dateInt = new ArrayList<>();
        Integer newToday = Integer.valueOf(today.replace(".",""));
       
        date = date.replace("."," ");
        Arrays.stream(date.split(" ",3)).forEach(d->dateInt.add(Integer.valueOf(d)));
        
        int ans = (dateInt.get(1) + exp) / 12; //몫
        int mod  = (dateInt.get(1) + exp) % 12; //나머지
        if (mod == 0){mod = 12; ans--;}        
        Integer newDate = (dateInt.get(0) + ans)* 10000 + mod * 100 + dateInt.get(2);
        
        //유효기간 만료면 true 
        System.out.println(String.valueOf(newToday)+"//"+String.valueOf(newDate));
        
        if(newToday>=newDate){return true;}
        return false;
        }
    
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String,Integer> termsMap = new HashMap<>();
        
        for(String term : terms){
            String[] typeAndExp = term.split(" ");
            termsMap.put(typeAndExp[0], Integer.valueOf(typeAndExp[1]));
        }
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0 ; i<privacies.length ;i++){
            String[] privacyString = privacies[i].split(" ");
            if(expCheck(today, privacyString[0], termsMap.get(privacyString[1]))){answer.add(i+1);}
        }
        return answer.stream().mapToInt(a->a).toArray();
    }
}
        

