class Solution {
    public int solution(int [][]board) {
        int answer = 0;
        
        final int la = board.length;
        final int lb = board[0].length;
        final int[][] dp = new int[la][lb];
        
        for (int a = 0 ; a < la ; a++) {
            for (int b = 0 ; b < lb ; b++) {
                if (board[a][b] == 0) continue;
                
                int left = b - 1 >= 0 ? dp[a][b - 1] : 0;
                int up = a - 1 >= 0 ? dp[a - 1][b] : 0;
                int leftUp = a - 1 >= 0 && b - 1 >= 0 ? dp[a - 1][b - 1] : 0;
                int min = Math.min(left, up);
                min = Math.min(min, leftUp);
                
                dp[a][b] = min + 1;
                answer = Math.max(answer, dp[a][b] * dp[a][b]);
            }
        }

        return answer;
    }
}