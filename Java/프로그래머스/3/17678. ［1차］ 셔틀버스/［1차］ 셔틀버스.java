import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        List<Integer> timeTable = Arrays.stream(timetable).map(x->timeToMin(x)).collect(Collectors.toList());
        Collections.sort(timeTable);

        int index = 0;
        int lastArrival = 0;
        for(int i=0; i<n;i++){
            int onCount = 0;
            int arrivalTime =9*60+i*t;
            
            while(index<timeTable.size()){
                int currentCrew = timeTable.get(index);
                if(currentCrew>arrivalTime){break;}
                onCount++;
                index++;
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

        String hour = String.valueOf(lastArrival/60);
        hour = hour.length()==1?"0"+hour:hour;
        String min = String.valueOf(lastArrival%60);
        min = min.length()==1?"0"+min:min;
        return hour+":"+min;
        
    }
    
    //시간을 분으로 환산
    public int timeToMin(String time){
        int hour = Integer.valueOf(time.split(":")[0]);
        int min = Integer.valueOf(time.split(":")[1]);
        return hour*60+min;
    }
}