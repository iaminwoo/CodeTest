import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> tMap = new HashMap<>();
        for(int i = 0 ; i < tangerine.length ; i++){
            final int t = tangerine[i];
            tMap.put(t, tMap.getOrDefault(t, 0) + 1);
        }
        
        int[] counts = new int[tMap.values().size()];
        
        int idx = 0;
        for(int count : tMap.values()) {
            counts[idx++] = count;
        }
        
        Arrays.sort(counts);
        
        int sum = 0;
        for(int i = counts.length - 1 ; i >= 0 ; i--) {
            if(sum < k) {
                answer++;
                sum += counts[i];
            } else {
                break;
            }
        }
        
        return answer;
    }
}