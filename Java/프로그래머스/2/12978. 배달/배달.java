import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][][] costs = new int[N + 1][N + 1][1];
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int cost = r[2];
            
            if (costs[a][b][0] == 0) {
                costs[a][b][0] = cost;
            } else {
                costs[a][b][0] = Math.min(costs[a][b][0], cost);
            }
            
            if (costs[b][a][0] == 0) {
                costs[b][a][0] = cost;
            } else {
                costs[b][a][0] = Math.min(costs[b][a][0], cost);
            }
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0});
        
        int[] min = new int[N + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[1] = 0;
        
        while(!queue.isEmpty()) {
            int[] currents = queue.poll();
            int current = currents[0];
            int sum = currents[1];
            
            for (int i = 1 ; i <= N ; i++) {
                int c = costs[current][i][0];
                if (c != 0 && min[i] > sum + c) {
                    min[i] = sum + c;
                    queue.add(new int[]{i, sum + c});
                }
            }
        }
        
        int answer = 0;
        for (int i = 1 ; i <= N ; i++) {
            if (min[i] <= K) answer++;
        }
        
        return answer;
    }
}