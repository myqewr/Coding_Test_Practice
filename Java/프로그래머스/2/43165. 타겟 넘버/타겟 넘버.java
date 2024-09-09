class Solution {
    
    public int dfs(int numbers[], int target, int nth, int result,int num){
        if(nth == numbers.length){
            if(result==target){
                num = num+1;}
            return num;}
        
        int currentNum = dfs(numbers, target, nth+1, result+numbers[nth], num);
        currentNum= dfs(numbers, target, nth+1, result-numbers[nth], currentNum);
        return currentNum;
        
    }
    
    public int solution(int[] numbers, int target) {
        return dfs(numbers,target,0,0,0);
    }
}