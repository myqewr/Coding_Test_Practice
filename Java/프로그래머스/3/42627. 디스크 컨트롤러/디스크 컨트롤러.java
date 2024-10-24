import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
     
        Arrays.sort(jobs,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        //소요시간 기준 우선순위 큐 생성
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        int lastTime = 0;
        int totalTime = 0;
        int index = 0;int len = 0;
        while(len<jobs.length){    
            while(index<jobs.length && jobs[index][0]<=lastTime){
                pq.add(jobs[index]);
                index++;
            }
            if(pq.size()==0){
                totalTime+= jobs[index][1];
                lastTime = jobs[index][0]+jobs[index][1];
                index++;len++;
            }
            else{
                int[] job = pq.poll();
                totalTime+= Math.abs(job[0]-lastTime) + job[1];
                lastTime += job[1];
                len++;}
            
        }
        return totalTime/jobs.length;
    }
}