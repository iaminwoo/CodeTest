import java.util.*;

class Solution {
    private boolean check(int a, int b, char[][] board) {
        // board[a][b]
        
        if(board[a][b] == ' ') return false;
        
        int[] da = {0, 1, 0, -1};
        int[] db = {1, 0, -1, 0};
        
        int m = board.length;
        int n = board[0].length;
        
        char originalC = board[a][b];
        
        for(int i = 0 ; i < 4 ; i++) {
            int originalA = a;
            int originalB = b;
            
            boolean match = true;
            
            for(int j = 1 ; j < 4 ; j++) {
                int d = (i + j) % 4;
                a = a + da[d];
                b = b + db[d];
                
                if(a < 0 || a >= m || b < 0 || b >= n || board[a][b] != originalC) {
                    match = false;
                    break;
                }
            }
            
            a = originalA;
            b = originalB;
            
            if(match) return true;
        }
        
        return false;
    }
    
    private char[][] fallBlock(boolean[][] remove, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int r = 0 ; r < m ; r++) {
            for(int c = 0 ; c < n ; c++) {
                if(remove[r][c]) board[r][c] = ' ';
            }
        }
        
        for(int r = m - 1 ; r >= 0 ; r--) {
            for(int c = n - 1 ; c >= 0 ; c--) {
                if(board[r][c] == ' ') continue;
                
                int newR = r;
                while(newR + 1 < m && board[newR + 1][c] == ' ') {
                    newR = newR + 1;
                }
                
                if(newR != r) {
                    board[newR][c] = board[r][c];
                    board[r][c] = ' ';
                }
            }
        }
        
        return board;
    } 
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] board2 = new char[m][n];
        
        for(int r = 0 ; r < m ; r++) {
            for(int c = 0 ; c < n ; c++) {
                board2[r][c] = board[r].charAt(c);
            }
        }
        
        while(true) {
            int count = 0;
            
            boolean[][] remove = new boolean[m][n];
        
            for(int r = 0 ; r < m ; r++) {
                for(int c = 0 ; c < n ; c++) {
                    if(check(r, c, board2)) {
                        count++;
                        remove[r][c] = true;
                    }
                }
            }
            
            if(count == 0) break;
            
            answer += count;

            board2 = fallBlock(remove, board2);
        }
        
        return answer;
    }
}