import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> places = new HashMap<>();
        
        // 1. 등수맵 만들기
        for (int i = 0 ; i < players.length ; i++) {
            places.put(players[i], i);
        }
        
        for (String call : callings) {
            // 2. 이름으로 등수 찾기
            int callPlace = places.get(call);
            
            // 3. 등수로 앞 사람 찾기
            int beforePlace = callPlace - 1;
            String beforePlayer = players[beforePlace];
            
            // 4. 앞 사람과 등수 교체
            players[beforePlace] = call;
            players[callPlace] = beforePlayer;
            
            places.put(call, beforePlace);
            places.put(beforePlayer, callPlace);
        }
        
        return players;
    }
}