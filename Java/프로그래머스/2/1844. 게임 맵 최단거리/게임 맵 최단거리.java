import java.util.Queue;
import java.util.LinkedList;

class Solution {
    private static class State {
        private final int y;
        private final int x;
        private final int count;
        
        private State(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Queue<State> queue = new LinkedList<>();
        
        visited[0][0] = true;
        queue.add(new State(0, 0, 1));
        
        while(!queue.isEmpty()) {
            State state = queue.poll();
            int y = state.y;
            int x = state.x;
            
            if(y == n - 1 && x == m - 1) return state.count;
            
            if(x - 1 >= 0 && maps[y][x - 1] == 1 && !visited[y][x - 1]) {
                visited[y][x - 1] = true;
                queue.add(new State(y, x - 1, state.count + 1));
            }
            
            if(x + 1 < m && maps[y][x + 1] == 1 && !visited[y][x + 1]) {
                visited[y][x + 1] = true;
                queue.add(new State(y, x + 1, state.count + 1));
            }
            
            if(y - 1 >= 0 && maps[y - 1][x] == 1 && !visited[y - 1][x]) {
                visited[y - 1][x] = true;
                queue.add(new State(y - 1, x, state.count + 1));
            }
            
            if(y + 1 < n && maps[y + 1][x] == 1 && !visited[y + 1][x]) {
                visited[y + 1][x] = true;
                queue.add(new State(y + 1, x, state.count + 1));
            }
        }
        
        return -1;
    }
}