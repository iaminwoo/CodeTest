import java.util.*;

class Solution {
    public int[] solution(String myString) {
        String[] parts = myString.split("x", myString.length());
        
        final int l = parts.length;
        int[] answer = new int[l];
        
        for (int i = 0 ; i < l ; i++) {
            answer[i] = parts[i].length();
        }
        
        return answer;
    }
}