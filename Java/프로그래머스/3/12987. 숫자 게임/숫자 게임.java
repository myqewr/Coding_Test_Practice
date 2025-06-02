import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        
        //bfs, dfs 안됨
        // 그리디..? 시간 부족...
        int size = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int sum = 0;
        int current = 0;
        for(int a : A){
            for(int i = current;i<size;i++){
                if(a<B[i]) {sum++; current = i+1;break;}
            }
        }
        
        
        int answer = sum;
        return answer;
    }
}