import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = -1;
        
        int[] target = scores[0];
        
        Arrays.sort(scores, (a, b) -> {
                    if (b[0] == a[0]) return a[1] - b[1];
                    return b[0] - a[0];
        });
        
        List<int[]> scoreList = new ArrayList<>();
        int max = 0;
        for (int[] s : scores) {
            max = Math.max(max, s[1]);
            
            if (max == s[1]) scoreList.add(s);
        }
        
        scoreList.sort((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));
        
        List<Integer> places = new ArrayList<>();
        for (int i = 0 ; i < scoreList.size() ; i++) {
            int[] current = scoreList.get(i);
            
            int place = i + 1;
            if (i >= 1) {
                int[] before = scoreList.get(i - 1);
                if (current[0] + current[1] == before[0] + before[1]) {
                    place = places.get(i - 1);
                }
            }
            
            places.add(place);
            
            if (current[0] == target[0] && current[1] == target[1]) answer = place;
        }
        
        return answer;
    }
}