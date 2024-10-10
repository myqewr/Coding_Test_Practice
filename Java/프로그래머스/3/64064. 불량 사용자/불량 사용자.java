import java.util.*;
import java.util.stream.Collectors;
class Solution {
    
    public List<String> f(String ban, List<String> names){
        
        List<String> banNameList = new ArrayList<>();
    
        char[] chars = ban.toCharArray();
        List<Integer> starIndex = new ArrayList<>();
        for(int i=0;i<ban.length();i++){
            if(String.valueOf(chars[i]).equals("*")){
                starIndex.add(i);
            }
        }
        
        for(String name: names){
            char[] charName = name.toCharArray();
            String value = "";
            for(int i=0;i<name.length();i++){
                if(starIndex.contains(i)){
                    value+="*";
                }
                else{value+=String.valueOf(charName[i]);}
            }
            if(value.equals(ban)){banNameList.add(name);}
        }
        return banNameList;
        
    }
    
    
    public  Map<List<String>,Integer> dfs(int nth, String[] banned, List<String> names, int num, Map<List<String>,Integer> map, List<String> list){

        if(banned.length==nth){
            list = list.stream().sorted().collect(Collectors.toList());
            map.put(list,1);
            return map;
        }
        String ban = banned[nth];
        List<String> ban_list = f(ban, names);
        for(String ban_name : ban_list){
            List<String> new_names = new ArrayList<>(names);
            new_names.remove(ban_name);
            List<String> newList= new ArrayList<>(list);
            newList.add(ban_name);
            map = dfs(nth+1, banned, new_names, num,map,newList);
        }
        return map;
     }
    
    public int solution(String[] user_id, String[] banned_id) {
        Map<List<String>,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        return dfs(0,banned_id,Arrays.asList(user_id),0,map,list).size();
    }
}