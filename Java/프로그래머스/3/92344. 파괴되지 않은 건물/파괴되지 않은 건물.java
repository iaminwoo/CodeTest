import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int la = board.length;
        int lb = board[0].length;
        
        int[][] sum = new int[la + 1][lb + 1];
        
        for (int[] s : skill) {
            int r1 = s[1], c1 = s[2];
            int r2 = s[3], c2 = s[4];
            int degree = s[0] == 1 ? -s[5] : s[5];
            
            sum[r1][c1] += degree;
            sum[r1][c2 + 1] += -degree;
            sum[r2 + 1][c1] += -degree;
            sum[r2 + 1][c2 + 1] += degree;
        }
        
        for (int row = 0 ; row < la ; row++) {
            for (int col = 1 ; col < lb ; col++) {
                sum[row][col] += sum[row][col - 1];
            }
        }
        
        for (int col = 0 ; col < lb ; col++) {
            for (int row = 1 ; row < la ; row++) {
                sum[row][col] += sum[row - 1][col];
            }
        }
        
        for (int row = 0 ; row < la ; row++) {
            for (int col = 0 ; col < lb ; col++) {
                if (board[row][col] + sum[row][col] > 0) answer++;
            }
        }
        
        return answer;
    }
}