import java.util.*;
class Solution {
    
    public String stringToSimple(String time){
        time=  time.replace(":","");
        int minute = Integer.valueOf(time)%100;
        int hour = Integer.valueOf(time)/100;
        return String.valueOf(hour*3600 +minute*60);
    }
    
    public String[] solution(String[][] plans) {
        
        List<String> answer = new ArrayList<>();
        Stack<String[]> uncompleted = new Stack<>();
        
        Arrays.stream(plans).forEach(p-> p[1] = stringToSimple(p[1]));
        Arrays.sort(plans, (a,b) -> Integer.valueOf(a[1])-Integer.valueOf(b[1]));
        int after = 0;
        int gap=0;
            
        for(int i=0;i<plans.length;i++){
                
            if(i==plans.length-1){
                answer.add(plans[i][0]);
                break;
            }
                
            after = Integer.valueOf(plans[i][1]) +  Integer.valueOf(plans[i][2])*60;
            gap = after - Integer.valueOf(plans[i+1][1]);  
            //시간을 초과할 경우
            if(gap>0){
                plans[i][2] = String.valueOf(gap);
                uncompleted.push(plans[i]);
             }
            //시간 초과 안한 경우                                  
            else if(gap<0){
                answer.add(plans[i][0]);
                
                while(uncompleted.size()!=0){
                    String[] stop = uncompleted.pop();
                    
                    after = after + Integer.valueOf(stop[2]);
                    gap = after - Integer.valueOf(plans[i+1][1]);
                    if(gap>0){
                        stop[2] = String.valueOf(gap);
                        uncompleted.push(stop);
                        break;
                    }
                    else if(gap<0){
                      answer.add(stop[0]); 
                    }
                    else{answer.add(stop[0]); break;}
                }
            }
            else{
               answer.add(plans[i][0]); 
            }
        }
        while(uncompleted.size()!=0){
            answer.add(uncompleted.pop()[0]);
        }
        return answer.toArray( new String[plans.length-1]);
    }
}