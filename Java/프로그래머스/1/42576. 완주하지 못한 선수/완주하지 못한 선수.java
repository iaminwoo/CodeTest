import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> partMap = new HashMap<>();
        
        for(String part : participant) {
            partMap.put(part, partMap.getOrDefault(part, 0) + 1);
        }
        
        for(String complete : completion) {
            int count = partMap.get(complete) - 1;
            if(count == 0) {
                partMap.remove(complete);
            } else {
                partMap.put(complete, count);
            }
        }
        
        return partMap.keySet().iterator().next();
    }
}