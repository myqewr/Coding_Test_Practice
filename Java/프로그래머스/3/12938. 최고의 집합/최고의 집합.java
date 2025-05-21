import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        
        if(n>s){int[]answer = new int[1]; answer[0]=-1; return answer;}
        
        int value = s/n;
        int rest = s%n;
        
        int[]answer = new int[n];
        for(int i=0;i<n;i++){
            if(i+1<=rest) answer[i] = value+1;
            else answer[i] = value;
        }
        
        Arrays.sort(answer);
        return answer;
    }
}