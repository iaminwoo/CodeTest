import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> connected = new HashMap<>();
        
        for(int[] e : edge) {
            int a = e[0];
            int b = e[1];
            
            connected.computeIfAbsent(a, k -> new ArrayList<Integer>()).add(b);
            connected.computeIfAbsent(b, k -> new ArrayList<Integer>()).add(a);
        }
        
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[1] = true;
        queue.offer(1);
        
        int size = 0;
        while(!queue.isEmpty()) {
            size = queue.size();
            
            for(int i = 0 ; i < size ; i++) {
                int current = queue.poll();

                for(int next : connected.get(current)) {
                    if(!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        
        return size;
    }
}