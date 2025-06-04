import java.util.*;
class Solution {
    public int solution(int[] a) {
        int size = a.length;
        
        int[]left = new int[size];
        int[] right = new int[size];
        
        left[0] = a[0];
        right[size-1] = a[size-1];
        
        for(int i=1;i<size;i++){
            left[i] = Math.min(left[i-1],a[i]);
        }
        for(int i=size-2;i>=0;i--){
            right[i] = Math.min(right[i+1],a[i]);
        }
        List<Integer> result = new ArrayList<>();
        for(int i=1;i<size-1;i++){
            if(left[i-1]<a[i] && right[i+1]<a[i]){continue;} // 양쪽 다 작은 경우
            result.add(a[i]);
        }
        
        int answer = result.size()+2;
        return answer;
    }
}
// 양 끝은 무조건 생존
// 양 옆에 제일 작은 값이 모두 나보다 작지만 않으면 무조건 생존함.