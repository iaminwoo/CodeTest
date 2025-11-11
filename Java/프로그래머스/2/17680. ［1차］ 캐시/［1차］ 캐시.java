import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Deque<String> cache = new ArrayDeque<>();
        
        for(int i = 0 ; i < cities.length ; i++){
            final String city = cities[i].toLowerCase();
            
            if(cache.contains(city)) {
                answer += 1;
                
                cache.remove(city);
                cache.offer(city);
            } else {
                answer += 5;
                
                cache.offer(city);
                if(cache.size() > cacheSize) cache.poll();
            }
        }
        
        return answer;
    }
}