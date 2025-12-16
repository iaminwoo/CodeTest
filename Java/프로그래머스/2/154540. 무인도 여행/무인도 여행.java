import java.util.*;

class Solution {
    private int[] da = {-1, 1, 0, 0};
    private int[] db = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        int la = maps.length;
        int lb = maps[0].length();
        
        char[][] mapArr = new char[la][lb];
        
        for (int a = 0 ; a < la ; a++) {
            for (int b = 0 ; b < lb ; b++) {
                mapArr[a][b] = maps[a].charAt(b);
            }
        }
        
        PriorityQueue<Integer> islands = new PriorityQueue<>();
        boolean[][] visited = new boolean[la][lb];
        
        for (int a = 0 ; a < la ; a++) {
            for (int b = 0 ; b < lb ; b++) {
                if (visited[a][b] || mapArr[a][b] == 'X') continue;
                
                Queue<int[]> queue = new ArrayDeque<>();
                int sum = 0;
                
                visited[a][b] = true;
                queue.add(new int[]{a, b});
                
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    
                    for (int i = 0 ; i < size ; i++) {
                        int[] current = queue.poll();
                        int ca = current[0];
                        int cb = current[1];
                        sum += mapArr[ca][cb] - '0';
                        
                        for (int d = 0 ; d < 4 ; d++) {
                            int newA = ca + da[d];
                            int newB = cb + db[d];
                            
                            if (newA < 0 || newB < 0 || newA > la - 1 || newB > lb - 1 || mapArr[newA][newB] == 'X') continue;
                            if (!visited[newA][newB]) {
                                visited[newA][newB] = true;
                                queue.add(new int[]{newA, newB});
                            }
                        }
                    }
                }
                
                islands.add(sum);
            }
        }
        
        int size = islands.size();
        if (size == 0) return new int[]{-1};
        
        int[] answer = new int[size];
        for (int i = 0 ; i < size ; i++) {
            answer[i] = islands.poll();
        }
        
        return answer;
    }
}