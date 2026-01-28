import java.util.*;

class Solution {
    private class Node implements Comparable<Node>{
        int index;
        int intensity;
        
        private Node(int idx, int it) {
            index = idx;
            intensity = it;
        }
        
        public int compareTo(Node other) {
            return Integer.compare(this.intensity, other.intensity);
        }
    }
    
    private int[] gateOrSummit;
    
    private boolean isGate(int index) {
        return gateOrSummit[index] == 1;
    }
    private boolean isSummit(int index) {
        return gateOrSummit[index] == 2;
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        gateOrSummit = new int[n + 1];
        for (int g : gates) {
            gateOrSummit[g] = 1;
        }
        for (int s : summits) {
            gateOrSummit[s] = 2;
        }
        
        List<Node>[] childrens = new List[n + 1];
        for (int i = 0 ; i < n + 1 ; i++) {
            childrens[i] = new ArrayList<>();
        }
        
        for (int[] p : paths) {
            int u = p[0];
            int v = p[1];
            
            if (!isGate(v) && !isSummit(u)) childrens[u].add(new Node(v, p[2]));
            if (!isGate(u) && !isSummit(v)) childrens[v].add(new Node(u, p[2]));
        }
        
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue();
        
        for (int g : gates) {
            pq.offer(new Node(g, 0));
        }
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            
            if (curr.intensity >= intensity[curr.index]) continue;
            intensity[curr.index] = curr.intensity;
            
            for (Node next : childrens[curr.index]) {
                pq.offer(new Node(next.index, Math.max(curr.intensity, next.intensity)));
            }
        }
        
        int[] answer = new int[2];
        answer[1] = Integer.MAX_VALUE;
        
        Arrays.sort(summits);
        for (int i = summits.length - 1 ; i >= 0 ; i--) {
            int curr = summits[i];
            
            if (answer[1] >= intensity[curr]) {
                answer[0] = curr;
                answer[1] = intensity[curr];
            }
        }
        
        return answer;
    }
}