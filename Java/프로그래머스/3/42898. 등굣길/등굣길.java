import java.util.*;

class Solution {
    private final int[][] mem = new int[101][101];
    
    public int solution(int m, int n, int[][] puddles) {
        for(int[] row : mem) {
            Arrays.fill(row, -1);
        }
        
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        
        for(int[] puddle : puddles) {
            isPuddle[puddle[1]][puddle[0]] = true;
        }
            
        return move(m, n, 1, 1, isPuddle);
    }
    
    private int move(int m, int n, int y, int x, boolean[][] isPuddle) {
        if(mem[y][x] != -1) return mem[y][x];
        
        if(x == m && y == n) return 1;
        
        int right = (x == m) || isPuddle[y][x + 1] ? 0 : move(m, n, y, x + 1, isPuddle);
        int down = (y == n) || isPuddle[y + 1][x] ? 0 : move(m, n, y + 1, x, isPuddle);
        
        return mem[y][x] = (right + down) % 1000000007;
    }
}