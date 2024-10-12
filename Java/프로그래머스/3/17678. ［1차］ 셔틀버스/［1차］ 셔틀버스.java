import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        List<Integer> timeTable = Arrays.stream(timetable).map(x->timeToMin(x)).collect(Collectors.toList());
        Collections.sort(timeTable);
        Queue<Integer> queue = new LinkedList<>(timeTable);

        int lastArrival = 0;
        for(int i=0; i<n;i++){
            int onCount = 0;
            int arrivalTime =540+i*t;
            
            while(queue.size()!=0){
                int currentCrew = ((LinkedList<Integer>) queue).peekFirst();
                if(currentCrew>arrivalTime){break;}
                queue.poll();
                onCount++;
                if(onCount==m){
                    lastArrival = currentCrew;
                    break;
                }
            }
            if(i==n-1){
                if(onCount==m){lastArrival-=1;}
                else lastArrival = arrivalTime;
            }
        }

        return String.format("%02d:%02d", lastArrival/60, lastArrival%60);

    }
    
    //시간을 분으로 환산
    public int timeToMin(String time){
        int hour = Integer.valueOf(time.substring(0,2));
        int min = Integer.valueOf(time.substring(3,5));
        return hour*60+min;
    }
}

