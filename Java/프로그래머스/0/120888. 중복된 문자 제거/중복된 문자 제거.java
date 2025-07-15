import java.util.*;

class Solution {
    public String solution(String my_string) {
        Set<Character> chars = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for(char c : my_string.toCharArray()) {
            if(!chars.contains(c)) {
                sb.append(c);
                chars.add(c);
            }
        }
        return sb.toString();
    }
}