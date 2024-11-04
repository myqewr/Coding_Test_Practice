class Solution {
    
    long nums (long r1,long r2,long x){
        long big = (long)Math.floor(Math.sqrt(r2*r2 - x*x));
        long small =r1<x?0:(long)Math.ceil(Math.sqrt(r1*r1 - x*x));
        return big -small+1;
    }
    
    public long solution(int r1, int r2) {
        long num = 0;
        for(int i=1;i<=r2;i++){
            num+=nums((long)r1,(long)r2,(long)i);
        }
        return num*4;
    }
}