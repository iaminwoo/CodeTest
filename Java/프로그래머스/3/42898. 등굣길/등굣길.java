import java.util.*;

class Solution {
    private final int[][] mem = new int[101][101];
    
    public int solution(int m, int n, int[][] puddles) {
        for(int[] row : mem) {
            Arrays.fill(row, -1);
        }
        
        return move(m, n, 1, 1, puddles);
    }
    
    private int move(int m, int n, int y, int x, int[][] puddles) {
        if(mem[y][x] != -1) return mem[y][x];
        
        if(x == m && y == n) return 1;
        
        int right = (x == m) || isPuddle(y, x + 1, puddles) ? 0 : move(m, n, y, x + 1, puddles);
        int down = (y == n) || isPuddle(y + 1, x, puddles) ? 0 : move(m, n, y + 1, x, puddles);
        
        return mem[y][x] = (right + down) % 1000000007;
    }
    
    private boolean isPuddle(int y, int x, int[][] puddles) {
        for(int[] puddle : puddles) {
            if(puddle[0] == x && puddle[1] == y) return true;
        }
        return false;
    }
}