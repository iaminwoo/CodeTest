import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if(x == y) return 0;
        
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        
        visited[x] = true;
        queue.add(x);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0 ; i < size ; i++) {
                int c = queue.poll();
                int[] nextNumber = {c + n, c * 2, c * 3};
                
                for(int next : nextNumber) {
                    if(next > y) continue;
                    
                    if(next == y) return answer + 1;
                    
                    if(!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            
            answer++;
        }
        
        return -1;
    }
}