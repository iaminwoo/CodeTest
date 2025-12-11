import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] w : wires) {
            int v1 = w[0];
            int v2 = w[1];
            
            map.computeIfAbsent(v1, k -> new ArrayList<>()).add(v2);
            map.computeIfAbsent(v2, k -> new ArrayList<>()).add(v1);
        }
        
        for (int[] w : wires) {
            int v1 = w[0];
            int v2 = w[1];
            
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[n + 1];
            
            int v1Count = 0;
            int v2Count = 0;
            
            visited[v1] = true;
            v1Count++;
            queue.add(v1);
            
            while(!queue.isEmpty()) {
                int size = queue.size();
                
                for (int i = 0 ; i < size ; i++) {
                    int v = queue.poll();
                    
                    for (int next : map.get(v)) {
                        if(!visited[next] && next != v2) {
                            visited[next] = true;
                            v1Count++;
                            queue.add(next);
                        }
                    }
                }
            }
            
            visited[v2] = true;
            v2Count++;
            queue.add(v2);
            
            while(!queue.isEmpty()) {
                int size = queue.size();
                
                for (int i = 0 ; i < size ; i++) {
                    int v = queue.poll();
                    
                    for (int next : map.get(v)) {
                        if(!visited[next] && next != v1) {
                            visited[next] = true;
                            v2Count++;
                            queue.add(next);
                        }
                    }
                }
            }
            
            int d = Math.max(v1Count - v2Count, v2Count - v1Count);
            answer = Math.min(d, answer);
        }
        
        return answer;
    }
}