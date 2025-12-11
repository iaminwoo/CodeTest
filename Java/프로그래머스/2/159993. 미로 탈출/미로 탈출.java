import java.util.*;

class Solution {
    // maze[a][b], 상하좌우
    private int[] da = {-1, 1, 0, 0};
    private int[] db = {0, 0, -1, 1};
    
    private int ma = 0;
    private int mb = 0;
    private String[][] maze;
    
    private int bfs(int a, int b, String target) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[ma][mb];
        
        int[] start = new int[]{a, b};
        visited[a][b] = true;
        queue.add(start);
        
        int cost = 1;
        
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0 ; i < size ; i++) {
                int[] c = queue.poll();
                
                for (int d = 0 ; d < 4 ; d++) {
                    int newA = c[0] + da[d];
                    int newB = c[1] + db[d];
                    
                    if (newA < 0 || newB < 0 || newA >= ma || newB >= mb) continue;
                    if (maze[newA][newB].equals("X")) continue;
                    
                    if (maze[newA][newB].equals(target)) {
                        return cost;
                    }
                    
                    if (!visited[newA][newB]) {
                        visited[newA][newB] = true;
                        queue.add(new int[]{newA, newB});
                    }
                }
            }
            
            cost++;
        }
        
        return 0;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        final int l = maps.length;
        int sa = 0, sb = 0;
        int la = 0, lb = 0;
        
        maze = new String[l][maps[0].length()];
        for (int i = 0 ; i < l ; i++) {
            String row = maps[i];
            maze[i] = row.split("");
            
            for (int j = 0 ; j < maze[i].length ; j++) {
                if (maze[i][j].equals("S")) {
                    sa = i;
                    sb = j;
                } else if (maze[i][j].equals("L")) {
                    la = i;
                    lb = j;
                }
            }
        }
        ma = maze.length;
        mb = maze[0].length;
        
        int result = bfs(sa, sb, "L");
        if (result == 0) return -1;
        answer += result;
        
        result = bfs(la, lb, "E");
        if (result == 0) return -1;
        answer += result;
        
        return answer;
    }
}