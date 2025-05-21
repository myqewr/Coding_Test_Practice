import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        
        StringBuilder s = new StringBuilder();
        for(int i=0;i<m.length();i++){
            if(m.charAt(i)=='#'){
                int lastIndex = s.length()-1;
                char low = Character.toLowerCase(s.charAt(lastIndex));
                s.setCharAt(lastIndex,low);
                continue;
            }
            s.append(m.charAt(i));
        }
        
        m = s.toString();    
        
        
        class Node{
            Integer time;
            String music;
            String name;
            public Node(Integer time,String name,String music){
                this.time = time;
                this.name = name;
                this.music = music;
            }
        }
        
        List<Node> musics = new ArrayList<>();
        for(String music : musicinfos){
            String[] info = music.split(",");
            int time = stringToTime(info[1]) - stringToTime(info[0]);
            
            StringBuilder ss = new StringBuilder();
                for(int i=0;i<info[3].length();i++){
                    if(info[3].charAt(i)=='#'){
                int lastIndex = ss.length()-1;
                char low = Character.toLowerCase(ss.charAt(lastIndex));
                ss.setCharAt(lastIndex,low);
                continue;
            }
            ss.append(info[3].charAt(i));
        }   
            musics.add(new Node(time,info[2],playedMusic(time,ss.toString())));
        }
        
        musics.sort((a,b)->Integer.compare(b.time,a.time));
       
        for(Node node: musics){
            if(node.music.contains(m)){
                return node.name;
            }
        }
        return "(None)";
    }
    
    public String playedMusic(Integer time, String code){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<time;i++){
            if(code.charAt(i%code.length())=='#'){
                int lastIndex = sb.length()-1;
                char low = Character.toLowerCase(sb.charAt(lastIndex));
                sb.setCharAt(lastIndex,low);
                continue;
            }
            sb.append(code.charAt(i%code.length()));
        }
        return sb.toString();
    }
    
    public Integer stringToTime(String time){
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min =  Integer.parseInt(parts[1]);
        return hour *60+min;
    }
}