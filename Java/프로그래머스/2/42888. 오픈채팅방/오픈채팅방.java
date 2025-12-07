import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> nicknameMap = new HashMap<>();
        int count = 0;
        
        for(String s : record) {
            String[] parts = s.split(" ");
            String action = parts[0];
            String username = parts[1];
            
            if (action.equals("Enter") || action.equals("Leave")) {
                count++;
            }
            
            if (action.equals("Enter") || action.equals("Change")) {
                String nickname = parts[2];
                nicknameMap.put(username, nickname);
            }
        }
        
        String[] answer = new String[count];
        int idx = 0;
        
        for(String s : record) {
            String[] parts = s.split(" ");
            String action = parts[0];
            String username = parts[1];
            
            if (action.equals("Enter")) {
                answer[idx++] = nicknameMap.get(username) + "님이 들어왔습니다.";
            } else if (action.equals("Leave")) {
                answer[idx++] = nicknameMap.get(username) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}