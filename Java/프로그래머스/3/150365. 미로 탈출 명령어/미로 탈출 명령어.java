import java.util.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int leastMove = Math.abs(x - r) + Math.abs(y - c);
        int moveLeft = k - leastMove;
        if (moveLeft < 0 || moveLeft % 2 != 0) return "impossible";
        
        StringBuilder sb = new StringBuilder();
        int curX = x, curY = y;

        for (int i = 0; i < k; i++) {
            if (curX < n && (Math.abs((curX + 1) - r) + Math.abs(curY - c)) <= k - i - 1) {
                sb.append("d"); curX++;
            }
            else if (curY > 1 && (Math.abs(curX - r) + Math.abs((curY - 1) - c)) <= k - i - 1) {
                sb.append("l"); curY--;
            }
            else if (curY < m && (Math.abs(curX - r) + Math.abs((curY + 1) - c)) <= k - i - 1) {
                sb.append("r"); curY++;
            }
            else {
                sb.append("u"); curX--;
            }
        }
        
        System.out.println(sb);
        return sb.toString();
    }
}