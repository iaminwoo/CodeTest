import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0 ; i < commands.length ; i++) {
            int[] command = commands[i];
            
            int start = command[0] - 1;
            int end = command[1];
            int target = command[2] - 1;
            int[] newArray = new int[end - start];
            
            int idx = 0;
            for(int j = start ; j < end ; j++) {
                newArray[idx++] = array[j];
            }
            
            Arrays.sort(newArray);
            
            answer[i] = newArray[target];
        }
        
        return answer;
    }
}