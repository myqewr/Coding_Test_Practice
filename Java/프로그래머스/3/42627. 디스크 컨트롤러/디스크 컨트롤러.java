import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
     
        Arrays.sort(jobs,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        List<Integer[]> jobList = new ArrayList<>();
        for(int i=0;i<jobs.length;i++){ 
            Integer[] temp = new Integer[2];
            temp[0] = Integer.valueOf(jobs[i][0]);
            temp[1] = Integer.valueOf(jobs[i][1]);
            jobList.add(temp);}
        
        Arrays.sort(jobs,(a,b)->a[1]-b[1]);
        List<Integer[]> jobListDuration = new ArrayList<>();
        for(int i=0;i<jobs.length;i++){ 
            Integer[] temp = new Integer[2];
            temp[0] = Integer.valueOf(jobs[i][0]);
            temp[1] = Integer.valueOf(jobs[i][1]);
            jobListDuration.add(temp);
        }
        
        int lastTime = 0;
        int totalTime = 0;
        while(jobList.size()!=0){
            Integer[] job = new Integer[2];
            
            //당장 처리할 프로세스가 없을 때 -> 요청이 들어온 시점으로 판단
            if(lastTime < jobList.get(0)[0]){
                job = jobList.get(0);
                totalTime+= job[1];
                lastTime =job[0] + job[1];
                jobList.remove(0);
                jobListDuration.remove(job);
                
            }
            //당장 처리해야 할 프로세스가 존재할 때 -> 소요 시간으로 판단
            else{
                int index=0;
                int minTime = Integer.MAX_VALUE;
                List<Integer[]> availableList = new ArrayList<>();
                for(int i=0;i<jobList.size();i++){
                    job = jobList.get(i);
                    if(job[0]>lastTime){break;}
                    if(job[1]<minTime){minTime = job[1]; index = i;}
                }
                totalTime+= Math.abs(jobList.get(index)[0]-lastTime) + jobList.get(index)[1];
                lastTime +=jobList.get(index)[1];
                jobList.remove(index);     
            }
        }
        return totalTime/jobs.length;
    }
}