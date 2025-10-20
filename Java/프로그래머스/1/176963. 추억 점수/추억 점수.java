import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < name.length ; i++) {
            map.put(name[i], yearning[i]);
        }
        
        for(int j = 0 ; j < photo.length ; j++) {
            int total = 0;
            for(String person : photo[j]) {
                total += map.getOrDefault(person, 0);
            }
            answer[j] = total;
        }
        
        return answer;
    }
}