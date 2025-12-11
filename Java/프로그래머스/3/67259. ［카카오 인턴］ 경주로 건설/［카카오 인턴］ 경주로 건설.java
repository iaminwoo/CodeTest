import java.util.*;

class Solution {
    // board[a][b]
    final int[] da = {-1, 1, 0, 0};
    final int[] db = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        int answer = 0;
        final int l = board.length;
        
        final int[][][] cost = new int[l][l][4];  // [a][b][direction]
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        final Queue<int[]> queue = new ArrayDeque<>();
        
        // 아래
        if (board[1][0] != 1) {
            cost[1][0][1] = 100;
            queue.add(new int[]{1, 1, 0, 100});
        }
        
        // 오른쪽
        if (board[0][1] != 1) {
            cost[0][1][3] = 100;
            queue.add(new int[]{3, 0, 1, 100});
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0 ; i < size ; i++) {
                int[] road = queue.poll();
                // 방향 direction, [a][b]
                int direction = road[0];
                int a = road[1];
                int b = road[2];
                int c = road[3];
                
                for (int d = 0 ; d < 4 ; d++) {
                    if (a == 0 && d == 0) continue;
                    if (a == l - 1 && d == 1) continue;
                    if (b == 0 && d == 2) continue;
                    if (b == l - 1 && d == 3) continue;
                    
                    int newA = a + da[d];
                    int newB = b + db[d];
                    if (newA < 0 || newA >= l || newB < 0 || newB >= l) continue;
                    if (board[newA][newB] == 1) continue;
                    
                    int newCost = c + 100;
                    if (direction != d) newCost += 500;
                    
                    if (cost[newA][newB][d] > newCost) {
                        cost[newA][newB][d] = newCost;
                        queue.add(new int[]{d, newA, newB, newCost});
                    }
                }
            }
        }
        
        int minCost = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            minCost = Math.min(minCost, cost[l - 1][l - 1][d]);
        }
        return minCost;
    }
}