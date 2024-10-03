import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int[][] met = new int[rows][columns];
        int num = 1;
        for(int i = 0 ; i<rows;i++){
            for(int j=0;j<columns;j++){
                met[i][j] = num;
                num+=1;
            }
        }
        int[] answer = new int[queries.length];
        
        for(int i = 0; i< queries.length ; i++){
            int min = 100000;
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            
            int previousValue = met[x1][y1];
            
            int currentY = y1;
            while(currentY!=y2){
                int value = met[x1][currentY+1];
                met[x1][currentY+1] = previousValue;
                min = Math.min(min,previousValue);
                previousValue = value;
                currentY+=1;
            }
            
            int currentX = x1;
            while(currentX!=x2){
                int value =  met[currentX+1][y2];
                met[currentX+1][y2] = previousValue;
                min = Math.min(min,previousValue);
                previousValue = value;
                currentX+=1;
            }
            
            int currentY2 = y2;
            while(currentY2!=y1){
                int value = met[x2][currentY2-1];
                met[x2][currentY2-1] = previousValue;
                min = Math.min(min,previousValue);
                previousValue = value;
                currentY2-=1;
            }
            
            int currentX2 = x2;
            while(currentX2!=x1){
                int value = met[currentX2-1][y1];
                met[currentX2-1][y1] = previousValue;
                min = Math.min(min,previousValue);
                previousValue = value;
                currentX2-=1;
            }
            answer[i] = min;
        }
        return answer;
    }
}