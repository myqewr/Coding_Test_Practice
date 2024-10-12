import java.util.*;
import java.util.stream.Collectors.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        Set<Integer> timeSet = new TreeSet<>();
        int[] timeArray = new int[24*60];
        
        Arrays.stream(timetable).forEach(x->{
            int converted = timeToMin(x);
            timeArray[converted]++;
            timeSet.add(converted);
        });
        
        int start = 0;
        int end = 24*60-1;
        
        System.out.println(valid(timeSet,timeArray,540,n,t,m));
        
        while(start<end){
            
            int mid = (start+end)/2;
            
            if(valid(timeSet,timeArray,mid,n,t,m)){
                start = mid+1;
            }
            else{
                end = mid;
            } 
        }
        
        String hour = String.valueOf((start-1)/60);
        hour = hour.length()==1?"0"+hour:hour;
        String min = String.valueOf((start-1)%60);
        min = min.length()==1?"0"+min:min;
        return hour+":"+min;
        
    }
    
    
    //시간을 분으로 환산
    public int timeToMin(String time){
        int hour = Integer.valueOf(time.split(":")[0]);
        int min = Integer.valueOf(time.split(":")[1]);
        return hour*60+min;
    }
        
    public Boolean valid(Set<Integer> set,int[] timeArrayOriginal,int time, int n, int t, int m){
        Set<Integer> timeSet = new TreeSet<>(set);
        timeSet.add(time);
        
        Integer[] line = timeSet.toArray(new Integer[timeSet.size()]);
        int[] timeArray = timeArrayOriginal.clone();
        timeArray[time]++;
        
        int index = 0;
        for(int i=0; i<n;i++){
            int currentMember = 0;
            int arrivalTime =9*60+i*t;
            
            while(index<line.length){
                int value = line[index];
                if(value>arrivalTime){break;}
                currentMember+=timeArray[value];
                if(currentMember>m){
                    timeArray[value]= currentMember - m;
                    break;
                }
                if(value==time){return true;}
                index++;
            } 
        }
        return false;
     
    }
}