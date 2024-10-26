import java.util.*;
class Solution {
    public int solution(int[] a) {
        
        //가장 작은 값을 찾기
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i=0;i<a.length;i++){
            if(a[i]<min){min = a[i]; minIndex = i;}
        }
        
        int answer = 0;
        
        //가장 작은 값을 기준으로 왼쪽 탐색
        // index 0에서부터 min값으로 오면서 특정 index를 기준으로 왼쪽이 모두 index보다 큰 경우를 검색. 
        //즉 index가 증가하면서 최소값을 갱신하는 횟수를 계산.
        int num = 0;
        int min_value = Integer.MAX_VALUE;
        for(int i = 0 ;i<minIndex;i++){
            if(min_value>a[i]){num++;min_value = a[i];}   
        }
        answer+=num;
        
        
        //배열의 끝 index에서부터 min index까지 거꾸로 오면서, 최소값을 갱신하는 횟수를 계산.
        num = 0;
        min_value = Integer.MAX_VALUE;
        for(int i = a.length-1 ;i>minIndex;i--){
            if(min_value>a[i]){num++;min_value = a[i];}   
        }
        answer+=num;
        
        return answer+1;
    }
}
