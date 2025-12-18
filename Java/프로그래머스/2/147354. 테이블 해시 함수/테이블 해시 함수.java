import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, Comparator.comparingInt((int[] row) -> row[0]).reversed());
        Arrays.sort(data, Comparator.comparingInt((int[] row) -> row[col - 1]));
        
        for (int i = row_begin ; i <= row_end ; i++) {
            int[] tuple = data[i - 1];
            
            int sum = 0;
            for (int n : tuple) {
                sum += n % i;
            }
            
            answer = answer ^ sum;
        }
        
        return answer;
    }
}