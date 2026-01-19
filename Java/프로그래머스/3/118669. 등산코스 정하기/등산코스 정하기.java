import java.util.*;

class Solution {
    private class Node implements Comparable<Node> {
        int index;
        int intensity;
        
        private Node(int i, int it) {
            index = i;
            intensity = it;
        }
        
        public int compareTo(Node other) {
            return Integer.compare(this.intensity, other.intensity);
        }
    }
    
    private Map<Integer, List<Node>> getGraph(int n, int[][] paths) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        
        for (int i = 0 ; i <= n ; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] p : paths) {
            int u = p[0];
            int v = p[1];
            int intensity = p[2];
            
            if (!isSummit(u) && !isGate(v)) graph.get(u).add(new Node(v, intensity));
            if (!isSummit(v) && !isGate(u)) graph.get(v).add(new Node(u, intensity));
        }
        
        return graph;
    }
    
    private boolean isSummit(int a) {
        return summitsBoolean[a];
    }
    
    private boolean isGate(int a) {
        return gatesBoolean[a];
    }
    
    private static boolean[] summitsBoolean;
    private static boolean[] gatesBoolean;
    private static final int INF = 100_000_000;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        answer[1] = INF;
        
        summitsBoolean = new boolean[n + 1];
        for (int s : summits) {
            summitsBoolean[s] = true;
        }
        gatesBoolean = new boolean[n + 1];
        for (int g : gates) {
            gatesBoolean[g] = true;
        }
        
        Map<Integer, List<Node>> graph = getGraph(n, paths);
        
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for (int g : gates) {
            intensity[g] = 0;
            pq.offer(new Node(g, 0));
        }
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (cur.intensity > intensity[cur.index]) continue;

            for (Node next : graph.get(cur.index)) {
                int newIntensity = Math.max(intensity[cur.index], next.intensity);
                if (intensity[next.index] > newIntensity) {
                    intensity[next.index] = newIntensity;
                    pq.offer(new Node(next.index, intensity[next.index]));
                }
            }
        }

        Arrays.sort(summits);
        for (int s : summits) {
            int summitIntensity = intensity[s];

            if (summitIntensity < answer[1]) {
                answer[0] = s;
                answer[1] = summitIntensity;
            }
        }
        
        return answer;
    }
}