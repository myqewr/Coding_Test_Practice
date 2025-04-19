import java.util.*;
class Solution {
    
    static int n;
    static int t;
    static int m;
    static PriorityQueue<Integer> timeTable;
    
    public String solution(int n, int t, int m, String[] timetable) {
        this.n=n;this.t=t;this.m=m; this.timeTable= timetable(timetable);
        
        int l = 1; //최소값
        int r = 23*60+59; //최대값
        
        int mid = (l+r)/2;
        
        while(l<r){    
            if(check(mid)){
                l = mid+1;
            }
            else{
                r = mid;
            }
            mid = (l+r)/2;
        }
        
        int hourInt = (l-1)/60;
        int minInt = (l-1)%60;
        String hour = hourInt<10?"0"+String.valueOf(hourInt):String.valueOf(hourInt);
        String min = minInt<10?"0"+String.valueOf(minInt):String.valueOf(minInt);
        return hour+":"+min; 
    }
    
    private Boolean check(int time){
        PriorityQueue<Integer> queue = new PriorityQueue<>(timeTable);
        queue.add(time);
        int base = 540;
        int last = 0;
        for(int i=0;i<n;i++){ // 운행 횟수
            if(queue.isEmpty()){break;}
            for(int j=0;j<m;j++){ //인원수
                if(queue.isEmpty()){break;}
                if(queue.peek()> (base + t*i)) {break;}
                queue.poll();
            }
        }

        if(queue.isEmpty()||queue.peek()>time){return true;}return false;
    }
    
    private PriorityQueue<Integer> timetable(String[] timetable){
        
        PriorityQueue<Integer> timetableNew = new PriorityQueue<>();
        
        for(String time : timetable){
            int hour = Integer.parseInt(time.split(":")[0]);
            int min = Integer.parseInt(time.split(":")[1]);
            timetableNew.add(hour * 60 + min);
        }
        return timetableNew;
        
        
        
        
    }
}