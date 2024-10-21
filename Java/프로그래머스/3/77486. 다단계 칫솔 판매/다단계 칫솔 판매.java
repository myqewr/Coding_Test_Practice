import java.util.*;
class Solution {
    
    static Map<String, Integer> pureIncome = new HashMap<>();
    static Map<String, List<Integer>> givenIncome = new HashMap<>();
    static Map<String, List<Integer>> sellInfo = new HashMap<>();
    static Map<String,List<String>> recommend = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        //판매원과 그 판매원이 소개시킨 다른 멤버 리스트
        for(int i=0;i<enroll.length;i++){
            List<String> temp = recommend.getOrDefault(referral[i],new ArrayList<String>());
            temp.add(enroll[i]);
            recommend.put(referral[i],temp);
            givenIncome.put(enroll[i],new ArrayList<Integer>());
            pureIncome.put(enroll[i],0);
        }
        givenIncome.put("-",new ArrayList<Integer>());
        
        //판매원과 판매원이 판 칫솔 금액
        for(int i=0;i<seller.length;i++){
            List<Integer> temp = sellInfo.getOrDefault(seller[i],new ArrayList<Integer>());
            temp.add(amount[i]*100);
            sellInfo.put(seller[i],temp);
        }
        
        dfs("","-");
        
        int[] answer = new int[enroll.length];
        for(int i=0;i<enroll.length;i++){
            answer[i] = pureIncome.get(enroll[i]);
        }
        return answer;
        
    }
    
    void dfs(String referral, String enrolled){
        
        //내가 판매한 것
        if(sellInfo.containsKey(enrolled)){
            int myIncome = 0;
            //내 판매금액의 10프로를 반납. 나머지는 내가 가짐.
            for(int sellCost :sellInfo.get(enrolled)){
                int haveToGiveIncome = sellCost/10;
                myIncome += sellCost - haveToGiveIncome;
                givenIncome.get(referral).add(haveToGiveIncome);
            }
            pureIncome.put(enrolled,myIncome);
        }
        
        //깊이 우선 탐색 //내가 추천한 회원에 대한 처리
        if(!recommend.containsKey(enrolled)){return;}
        for(String enrolledMan : recommend.get(enrolled)){
            dfs(enrolled,enrolledMan);
        }
    
        
        if(enrolled.equals("-") || givenIncome.get(enrolled).size()==0){return;}
        // 내가 추천한 판매원들 각각으로 부터 받은 금액의 10프로의 합 반납. 나머지 가짐.
        int myIncome = 0;
        for(int list : givenIncome.get(enrolled)){
            int haveToGiveIncome = list/10;
            myIncome += list- haveToGiveIncome;
            if(haveToGiveIncome!=0){
                givenIncome.get(referral).add(haveToGiveIncome);
            }   
        }
        pureIncome.put(enrolled,pureIncome.get(enrolled)+myIncome);
        return;
    }
}