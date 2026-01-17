import java.util.*;

class Solution {
    private class Node implements Comparable<Node> {
        int index;
        int fare;
        
        private Node(int i, int f) {
            index = i;
            fare = f;
        }
        
        public int compareTo(Node other) {
            return Integer.compare(this.fare, other.fare);
        }
    }
    
    private Map<Integer, List<Node>> getGraph(int n, int[][] fares) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        
        for (int i = 1 ; i <= n ; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] f : fares) {
            int u = f[0];
            int v = f[1];
            int fare = f[2];
            
            graph.get(u).add(new Node(v, fare));
            graph.get(v).add(new Node(u, fare));
        }
        
        return graph;
    }
    
    private static final int INF = 200_000_000;
    
    private int[] getFares(int n, int s, Map<Integer, List<Node>> graph) {
        int[] fares = new int[n + 1];
        Arrays.fill(fares, INF);
        
        fares[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (cur.fare > fares[cur.index]) continue;
            
            for (Node next : graph.get(cur.index)) {
                int cost = fares[cur.index] + next.fare;
                
                if (cost < fares[next.index]) {
                    fares[next.index] = cost;
                    pq.offer(new Node(next.index, cost));
                }
            }
        }
        
        return fares;
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        Map<Integer, List<Node>> graph = getGraph(n, fares);
        
        int[] fromS = getFares(n, s, graph);
        int[] fromA = getFares(n, a, graph);
        int[] fromB = getFares(n, b, graph);
        
        int answer = INF;
        
        for (int i = 1 ; i <= n ; i++) {
            answer = Math.min(answer, fromS[i] + fromA[i] + fromB[i]);
        }
        
        return answer;
    }
}