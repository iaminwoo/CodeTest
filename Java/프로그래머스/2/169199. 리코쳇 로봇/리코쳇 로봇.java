import java.util.*;

class Solution {
    private int[] da = {-1, 1, 0, 0};
    private int[] db = {0, 0, -1, 1};
    
    public int solution(String[] board) {
        int la = board.length;
        int lb = board[0].length();
        
        int a = 0;
        int b = 0;
        char[][] arr = new char[la][lb];
        for (int i = 0 ; i < la ; i++) {
            for (int j = 0 ; j < lb ; j++) {
                arr[i][j] = board[i].charAt(j);
                if (arr[i][j] == 'R') {
                    a = i;
                    b = j;
                }
            }
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[la][lb];
        
        visited[a][b] = true;
        queue.offer(new int[]{a, b, 0});
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0 ; i < size ; i++) {
                int[] c = queue.poll();
                a = c[0];
                b = c[1];
                int cost = c[2];
                
                if (arr[a][b] == 'G') return cost;
                
                for (int d = 0 ; d < 4 ; d++) {
                    int newA = a;
                    int newB = b;
                    
                    while (newA >= 0 && newA <= la - 1 && newB >= 0 && newB <= lb - 1 && arr[newA][newB] != 'D') {
                        newA = newA + da[d];
                        newB = newB + db[d];
                    }
                    
                    newA = newA - da[d];
                    newB = newB - db[d];
                    
                    if ((newA != a || newB != b) && !visited[newA][newB]) {
                        visited[newA][newB] = true;
                        queue.offer(new int[]{newA, newB, cost + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}