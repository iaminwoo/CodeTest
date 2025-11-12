import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> set = new HashSet<>();
        for(String s : phone_book){
            set.add(s);
        }
        
        for(String s : phone_book){
            for(int i = 1 ; i < s.length() ; i++){
                String prefix = s.substring(0, i);
                if(set.contains(prefix)) answer = false;
            }
        }
        
        return answer;
    }
}