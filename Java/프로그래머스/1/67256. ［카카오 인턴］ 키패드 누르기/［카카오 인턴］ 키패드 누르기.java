import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
    
        int[][] nums = {{1,2,3},
                        {4,5,6},
                        {7,8,9}, 
                        {10,0,11}};
       
        int[][] distance = new int[12][2];
        
        for(int x=0;x<4;x++){
            
            for(int y=0;y<3;y++){
                distance[nums[x][y]] = new int[]{x,y};}
        }
        
        String answer = "";
        int left = 10;
        int right = 11;
        
        for(int num : numbers){
        
            if(distance[num][1]==2){
                right = num;
                answer = answer+"R";
            }
            else if(distance[num][1]==0){
                left = num;
                answer = answer+"L";
            }
            
            else {
                int left_d =  Math.abs(distance[num][0] - distance[left][0])  
                            +Math.abs(distance[left][1] - distance[num][1]);
                int right_d =  Math.abs(distance[num][0] - distance[right][0])  
                            +Math.abs(distance[num][1] - distance[right][1]);
            
                if(left_d<right_d){
                    left = num;
                    answer = answer+ "L";
                }
                else if(left_d>right_d){
                    right = num;
                    answer = answer+ "R";
                }
                else {
                    if(hand.equals("right")){
                        right = num;
                        answer = answer+ "R";}
                    else {
                        left = num;
                        answer = answer+ "L";}}}}
        return answer;
    }
}