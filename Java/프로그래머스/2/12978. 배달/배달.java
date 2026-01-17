import java.util.*;

class Solution {
    private class Node implements Comparable<Node> {
        int index;
        int dist;
        
        private Node(int i, int d) {
            index = i;
            dist = d;
        }
        
        public int compareTo(Node other) {
            return Integer.compare(this.dist, other.dist);
        }
    }
    
    private Map<Integer, List<Node>> getGraph(int N, int[][] road) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        
        for (int i = 0 ; i <= N ; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] r : road) {
            int u = r[0];
            int v = r[1];
            int dist = r[2];
            
            graph.get(u).add(new Node(v, dist));
            graph.get(v).add(new Node(u, dist));
        }
        
        return graph;
    }
    
    private static final int INF = 100_000_000;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        Map<Integer, List<Node>> graph = getGraph(N, road);
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        
        dist[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curIdx = cur.index;
            int curDist = cur.dist;
            
            if (curDist > dist[curIdx]) continue;
            
            for (Node n : graph.get(curIdx)) {
                int cost = dist[curIdx] + n.dist;
                
                if (cost < dist[n.index]) {
                    dist[n.index] = cost;
                    pq.offer(new Node(n.index, cost));
                }
            }
        }
        
        for (int i = 1 ; i <= N ; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
}