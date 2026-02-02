import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0 ; i < commands.length ; i++) {
            int[] c = commands[i];
            int start = c[0];
            int end = c[1];
            int index = c[2] - 1;
            
            int[] check = new int[end - start + 1];
            System.arraycopy(array, start - 1, check, 0, end - start + 1);
            
            Arrays.sort(check);
            
            answer[i] = check[index];
        }
        
        return answer;
    }
}