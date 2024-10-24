import java.util.*;
class Solution
{
    public int solution(String s){
        //string을 string 배열로 변환
        char[] charString = s.toCharArray();
        String[] str = new String[s.length()];

        for(int i=0;i<s.length();i++){
            str[i] = String.valueOf(charString[i]);}
        
        int max = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            //팰린드롬이 홀수일 경우
            int left = i-1;
            int right =i+1;
            int lenOfOdd = 1;
            while(left>=0 && right<len&& str[left].equals(str[right])){
                lenOfOdd+=2;
                left--;
                right++;
            }
            //팰린드롬이 짝수일 경우
            int lenOfEven = 0;
            if(i+1<len && str[i].equals(str[i+1])){
                lenOfEven = 2;
                int l = i-1;
                int r = i+2;
                while(l>=0 && r<len && str[l].equals(str[r])){
                    lenOfEven+=2;
                    l--;
                    r++;
                }
            }
            max = Math.max(Math.max(lenOfOdd,lenOfEven),max);  
        }
        return max;
    }
}