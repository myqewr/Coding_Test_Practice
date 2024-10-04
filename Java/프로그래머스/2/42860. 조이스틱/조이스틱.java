import java.util.*;
class Solution {
    public int solution(String name) {
        
        String[] alphabet  = {"A","B","C","D","E","F","G",
                            "H","I","J","K","L","M","N","O","P",
                            "Q","R","S","T","U","V","W","X","Y","Z"};
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<alphabet.length;i++){
            map.put(alphabet[i],i);}
        
        List<String> nameList = new ArrayList<>(); 
        List<Integer> aLoc = new ArrayList<>();
        int index = 0;
        for(char cha : name.toCharArray()){
            nameList.add(String.valueOf(cha));
            if(String.valueOf(cha).equals("A")){aLoc.add(index);}
            index+=1;
        }
        
        
        //앞으로 쭉가기
        int straightNum = 0;
        for(int i=0;i<name.length();i++){
            String back = name.substring(i+1,name.length());
            back = back.replaceAll("A","");
            if(back.length()==0){break;}
            straightNum+=1;
            
        }
        
        //앞으로 가다가 뒤로 돌아가기
        int min = straightNum;
        for(int a : aLoc){
            int num = (a-1)*2>=0?(a-1)*2:0;
            for(int i = name.length()-1 ; i > a ; i--){
                String back = name.substring(a+1,i+1);
                back = back.replaceAll("A","");
                if(back.length()==0){
                    break;
                }
                num+=1;
            }
            min = Math.min(min,num);
        }
        
        //뒤로 가다가 앞으로 돌아오기
        aLoc.sort((a,b)->b-a);
        for(int a : aLoc){
            int num = (name.length()-a-1)*2-1>=0?(name.length()-a-1)*2-1:0;
            for(int i =0 ; i < name.length() ; i++){
                String back = name.substring(i,a+1);
                back = back.replaceAll("A","");
                if(back.length()==0){
                    break;
                }
                num+=1;
            }
            min = Math.min(min,num);
        }
        
        
        int charLoc = 0 ;
        for(int i = 0 ; i< name.length();i++){
            int value = map.get(nameList.get(i));
            value = value <= 25-value+1 ? value : 25-value+1;
            charLoc += value;
        }
        
        int answer = min + charLoc;
        
        
        return answer;
    }
}