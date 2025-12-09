import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        Map<Integer, List<Integer>> connected = new HashMap<>();
        int[] times = new int[n + 1];
        
        for (int[] r : roads) {
            int a = r[0];
            int b = r[1];
            
            connected.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            connected.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }
        
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        
        int t = 0;
        visited[destination] = true;
        queue.add(destination);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0 ; i < size ; i++) {
                int node = queue.poll();
                times[node] = t;
                
                for (int next : connected.get(node)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            
            t++;
        }
        
        int[] answer = new int[sources.length];
        
        for (int i = 0 ; i < sources.length ; i++) {
            int returnTime = times[sources[i]];
            if(sources[i] != destination && returnTime == 0) returnTime = -1;
            
            answer[i] = returnTime;
        }
        
        return answer;
    }
}