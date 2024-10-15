import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String,Integer> totalNumPerGen = new HashMap<>();
        Map<String,List<Integer>> songListPerGen = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            String gen = genres[i];
            int currentNum = totalNumPerGen.getOrDefault(gen,0);
            totalNumPerGen.put(gen,currentNum+plays[i]);
            
            List<Integer> songList = songListPerGen.getOrDefault(gen,new ArrayList<Integer>());
            songList.add(i);
            songListPerGen.put(gen, songList);
        }
        List<Integer> totalNums = totalNumPerGen.values().stream().sorted((a,b)->b-a).collect(Collectors.toList());
        
        
        List<String> topGenres = new ArrayList<>();
        for(int i=0;i<totalNums.size();i++){
            int topGenreNum = totalNums.get(i);
            for(String key : totalNumPerGen.keySet()){
                if(totalNumPerGen.get(key) == topGenreNum){
                    topGenres.add(key);
                }
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        for(String gen : topGenres){
            List<Integer> topSongs = songListPerGen.get(gen).stream().sorted().collect(Collectors.toList());;
            for(int j=0;j<2;j++){
                int max = 0;
                int maxNum = 0;
                for(int songNum : topSongs){
                    if(plays[songNum]>max){
                        max = plays[songNum];
                        maxNum = songNum;
                    }
                }
                answer.add(maxNum);
                topSongs.remove((Integer)maxNum);
                if(topSongs.size()==0){break;}
            }
        }
        return answer.stream().mapToInt(i->i).toArray(); 
    }
}
 