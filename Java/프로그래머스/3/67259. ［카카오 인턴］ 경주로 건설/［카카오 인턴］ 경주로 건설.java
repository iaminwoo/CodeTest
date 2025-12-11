import java.util.*;

class Solution {
    // board[a][b]
    final int[] da = {-1, 1, 0, 0};
    final int[] db = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        final int l = board.length;
        
        final int[][][] cost = new int[l][l][4];  // [a][b][direction]
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // 아래
        if (board[1][0] != 1) {
            cost[1][0][1] = 100;
            pq.add(new int[]{100, 1, 1, 0});
        }
        
        // 오른쪽
        if (board[0][1] != 1) {
            cost[0][1][3] = 100;
            pq.add(new int[]{100, 3, 0, 1});
        }
        
        int minCost = Integer.MAX_VALUE;
        
        while (!pq.isEmpty()) {
            int size = pq.size();
            
            for (int i = 0 ; i < size ; i++) {
                int[] road = pq.poll();
                // 방향 direction, [a][b]
                int c = road[0];
                int direction = road[1];
                int a = road[2];
                int b = road[3];
                
                if (a == l - 1 && b == l - 1) {
                    minCost = Math.min(minCost, c);
                }
                
                if (c > cost[a][b][direction]) continue;
                
                for (int d = 0 ; d < 4 ; d++) {
                    int newA = a + da[d];
                    int newB = b + db[d];
                    
                    if (newA < 0 || newA >= l || newB < 0 || newB >= l) continue;
                    if (board[newA][newB] == 1) continue;
                    
                    int newCost = c + 100;
                    if (direction != d) newCost += 500;
                    
                    if (cost[newA][newB][d] > newCost) {
                        cost[newA][newB][d] = newCost;
                        pq.add(new int[]{newCost, d, newA, newB});
                    }
                }
            }
        }
        
        return minCost;
    }
}