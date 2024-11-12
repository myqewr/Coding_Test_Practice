import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[0]-a[0]==0?a[1]-b[1]:b[0]-a[0]);
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a,b)-> b[0]+b[1]-a[0]-a[1]);
        
        for(int[] score : scores){pq.add(score);}
        
        int[] target = scores[0];
        
        int max1 = -1 ;
        int max2 = -1;
        while(pq.size()!=0){
            int[] score = pq.poll(); 
            if(score[0]<max1 && score[1]<max2){
                if(score.equals(target)){return -1;}
                continue;}
            pq2.add(score);
            max1 = Math.max(max1,score[0]);
            max2 = Math.max(max2,score[1]);
        }
        
        int rank = 0;
        int targetNum = target[0]+target[1];
        while(pq2.size()!=0){
            int[] score = pq2.poll();
            int scoreNum = score[0]+score[1];
            rank++; 
            if(scoreNum==targetNum){break;}
        }
        return rank;
    }
}