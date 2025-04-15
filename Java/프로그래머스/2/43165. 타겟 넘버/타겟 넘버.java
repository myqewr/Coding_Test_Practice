import java.util.*;
import java.util.Collections;

class Solution {
    public int solution(int[] numbers, int target) {
        List<Integer> numberList = new ArrayList<>();
        for(int number:numbers){numberList.add(number);}
        return dfs(numberList,target,0);
        }
    
    
    private int dfs(List<Integer> numbers, int target, int current){
        if(numbers.isEmpty()){
            if(current==target) {return 1;}
            else return 0;
        }
        
        int sum = 0;
        
        List<Integer> newNumbers = new ArrayList<>(numbers);
        int value = newNumbers.get(0);
        newNumbers.remove(0);
        sum+=dfs(newNumbers, target,current+value);
        sum+=dfs(newNumbers, target,current-value);
            
        return sum;
    }
}

   