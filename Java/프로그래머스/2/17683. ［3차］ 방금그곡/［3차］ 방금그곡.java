import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        
        String answer = "(None)";
        int timeMax = 0;
        m = m.replace("C#","c").replace("D#","d").replace("E#","e").replace("F#","f").replace("G#","g").replace("A#","a").replace("B#","b");
        for(String music : musicinfos){
            String[] musicInfo = music.split(",",4);
            int startTime = Integer.valueOf(musicInfo[0].split(":")[0]) * 60+ Integer.valueOf(musicInfo[0].split(":")[1]); 
            int finishTime = Integer.valueOf(musicInfo[1].split(":")[0]) * 60+ Integer.valueOf(musicInfo[1].split(":")[1]); 
            int duration = finishTime - startTime;
            
            String note = musicInfo[3].replace("C#","c").replace("D#","d").replace("E#","e").replace("F#","f").replace("G#","g").replace("A#","a").replace("B#","b");
            
            String playNote = "";
            for (int i=0 ;i<duration;i++){
                playNote+= note.substring(i%note.length(),i%note.length()+1) ; 
            }
            if(playNote.contains(m)){
                if(timeMax<duration){answer = musicInfo[2];timeMax = duration;}
            }
        }
        return answer;
    }
}