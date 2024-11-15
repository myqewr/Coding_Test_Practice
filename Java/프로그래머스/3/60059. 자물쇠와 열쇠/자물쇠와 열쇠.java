import java.util.*;
class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int len = key.length;
        int lockLen = lock.length;
        int offset = key.length-1;
        int extendedLen = lockLen + len*2-2;
        int sliding = extendedLen - len;
        
        int[][] extendedLock = new int[extendedLen][extendedLen];
        for(int i=0;i<lockLen;i++){
            for(int j=0;j<lockLen;j++){
                extendedLock[i+offset][j+offset] = lock[i][j];
            }
        }
        
        Queue<int[][]> rtKeyList = new LinkedList<>();  
        rtKeyList.add(key);
        //4번 회전
        for(int r = 1; r<=4;r++){
            int[][] rotatedKey = rtKeyList.poll();
            for(int i=0;i<=sliding;i++){
                for(int j=0;j<=sliding;j++){
                    int[][] trial = new int[extendedLen][extendedLen];
                    
                    for(int x=0;x<extendedLen;x++){
                        for(int y=0;y<extendedLen;y++){
                            trial[x][y] = extendedLock[x][y];
                        }
                    }
                    int mul = 1;
                    for(int m =0;m<len;m++){
                        for(int n=0;n<len;n++){
                            trial[m+i][n+j] +=rotatedKey[m][n];
                        }
                    }
                    
                    for(int m =0;m<lockLen;m++){
                        for(int n=0; n<lockLen;n++){
                            mul*=trial[len-1+m][len-1+n];
                        }
                    }
                    if(mul==1){return true; }
                }
            }
        
            if(r==4){break;}
            //시계방향 90도 회전
            int[][] nextKey = new int[len][len];
            for(int i=0;i<len;i++){
                for(int j=0;j<len;j++){
                    nextKey[j][Math.abs(i-len+1)] = rotatedKey[i][j];
                }
            }
            rtKeyList.add(nextKey);
        }

        boolean answer = false;
        return answer;   
    }
}