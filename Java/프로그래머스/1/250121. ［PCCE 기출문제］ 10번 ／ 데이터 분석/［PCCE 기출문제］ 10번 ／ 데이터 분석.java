import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int index1 =  0;
        int index2 = 0;
        int[][] tempAnswer = {};
        
        if(ext.equals("date")){index1 = 1;}
        else if (ext.equals("maximum")){index1 = 2;}
        else if (ext.equals("remain")){index1 = 3;}
        
        if(sort_by.equals("date")){index2 = 1;}
        else if (sort_by.equals("maximum")){index2 = 2;}
        else if (sort_by.equals("remain")){index2 = 3;}
        
        //List<int[]> dataTemp = Arrays.asList(data);
        List<int []> dataTemp = new ArrayList<int []>();
            
        for(int[] dt : data) {
            System.out.println(dt[index1]);
            System.out.println(val_ext);
            if(dt[index1] < val_ext){
                System.out.println(dt[index1]);
                dataTemp.add(dt);
            }
        }
        
        // dataTemp = dataTemp.stream().filter(d->d[index1] > val_ext).collect(Collectors.toList());
        
        data = dataTemp.toArray(new int[dataTemp.size()][4]);
        
        
        int stop = 0;
        while(stop==0){
            stop = 1;
            for(int i= 0;i< data.length-1; i++){
                if(data[i][index2] > data[i+1][index2]){
                    int [] temp = data[i];
                    data[i] = data[i+1];
                    data[i+1] = temp;
                    stop = stop * 0;
                }
            }
        }
        
        int[][] answer = {};
        
        answer = data;
        return answer;
    }
}