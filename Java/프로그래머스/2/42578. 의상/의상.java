import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        final Map<String, Integer> map = new HashMap<>();
        
        for(String[] c : clothes) {
            String type = c[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        for(String t : map.keySet()) {
            answer = answer * (map.get(t) + 1);
        }
        
        return answer - 1;
    }
}