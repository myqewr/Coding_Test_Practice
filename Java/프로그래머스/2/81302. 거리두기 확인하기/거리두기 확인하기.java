import java.util.*;
import java.util.stream.Collectors;
class Solution {
    
    public int main(String[] place){
        
        String[][] location = new String[5][5];
        List<Integer[]> taken = new ArrayList<>(); 
        
        //2차원 행렬로 n번째 대기실 변환. 착석된 자리 위치 추출하기. 
        for(int x = 0 ; x<5 ; x++){
            char[] charSits = place[x].toCharArray();
            for(int y = 0; y<5;y++){
                String type = String.valueOf(charSits[y]);
                location[x][y] = type;
                if(type.equals("P")){
                    Integer[] temp = {x,y};
                    taken.add(temp);
                }
            }
        }
        List<Integer[]> notChecked = new ArrayList<>(taken);
        for(Integer[] loc1 : taken){
            notChecked.remove(loc1);
            for(Integer[] loc2: notChecked){
                
                int dx = Math.abs(loc2[1]-loc1[1]); 
                int dy = Math.abs(loc2[0]-loc1[0]);
                
                //거리가 1
                if(dx+dy==1){return 0;}
                //거리가 2 (1+1)
                if(dx+dy==2 && dx==1){
                    int sy = Math.min(loc2[1],loc1[1]);
                    int sx = Math.min(loc2[0],loc1[0]);
                    
                    int l1 = location[sx][sy].equals("X")?2:1;
                    int l2 = location[sx+1][sy].equals("X")?2:1;
                    int l3 = location[sx][sy+1].equals("X")?2:1;
                    int l4 = location[sx+1][sy+1].equals("X")?2:1;
                    if(l1*l2*l3*l4!=4){return 0;}
                }
                //거리가 2 (2+0)
                if(dx+dy==2 && dx!=1){
                    int mx = (loc2[1]+loc1[1])/2;
                    int my = (loc2[0]+loc1[0])/2;
                    if(!location[my][mx].equals("X")){return 0;}
                }  
            }
        }
        
        //거리두기가 모두 잘 되어 있으면 마지막으로 1반환
        return 1;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int nth = 0;
        while(nth<5){
            String[] place= places[nth];
            answer[nth] = main(place);
            nth+=1;
        }
        return answer;
    }
}