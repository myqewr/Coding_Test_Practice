import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.Pattern;
class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        
    
        List<List<String>> result= dfs(0, Arrays.asList(user_id),banned_id,new ArrayList<>(),banned_id.length-1);        
        
        return (int)result.stream().distinct().count();
    
    }
    
    
    private List<List<String>> dfs(int index,List<String> candidates,String[]banned_id, List<String> list, int lastIndex){
        if(index > lastIndex){
            Collections.sort(list);
            List<List<String>> result= new ArrayList<>(); 
            result.add(list);
            return result;}
        
        String text = banned_id[index];
        long num =  candidates.stream().filter(c->isMatch(c,text)).count();
        if(num==0) {return new ArrayList<>();}
        
        List<String> selected = candidates.stream().filter(c->isMatch(c,text)).collect(Collectors.toList());
        
        List<List<String>> set = new ArrayList<>();
        for(String value : selected){
            List<String> newCandidates = new ArrayList<>(candidates);
            newCandidates.remove(value);
            List<String> newList = new ArrayList<>(list);
            newList.add(value);
            List<List<String>> temp =dfs(index+1, newCandidates,banned_id,newList,lastIndex);
            set.addAll(temp);
        }
        return set;       
    }
    
    public static boolean isMatch(String target,String pattern) {
        // 길이가 다르면 무조건 false
        if (pattern.length() != target.length()) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            char t = target.charAt(i);

            if (p != '*' && p != t) {
                return false; // 와일드카드가 아닌데 다르면 불일치
            }
        }
        return true;
    }
}