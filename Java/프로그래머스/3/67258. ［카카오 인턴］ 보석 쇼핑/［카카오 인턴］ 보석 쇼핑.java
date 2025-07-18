import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> allGems = new HashSet<>(List.of(gems));
        
        Map<String, Integer> includes = new HashMap<>();
        
        int start = 0;
        int end = gems.length - 1;
        
        int s = 0;
        int e = 0;
        
        includes.put(gems[0], 1);
        
        while(s < gems.length) {
            if(includes.keySet().size() == allGems.size()) {
                if(e - s < end - start) {
                    start = s;
                    end = e;
                }
                
                includes.put(gems[s], includes.get(gems[s]) - 1);
                if(includes.get(gems[s]) == 0) {
                    includes.remove(gems[s]);
                }
                s++;
            } else if(e < gems.length - 1) {
                e++;
                includes.put(gems[e], includes.getOrDefault(gems[e], 0) + 1);
            } else {
                break;
            }
        }
        
        return new int[]{start + 1, end + 1};
    }
}