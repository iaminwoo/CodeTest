import java.util.*;

class Solution {
    private static class Node {
        private int depth = 1;
        private Node parent = null;
        
        private boolean isConnected(Node v) {
            return this.root() == v.root();
        }
        
        private Node root() {
            if(this.parent == null) return this;
            return this.parent.root();
        }
        
        private void merge(Node v) {
            if(this.isConnected(v)) return;
            
            Node rootU = this.root();
            Node rootV = v.root();
            
            if(rootU.depth < rootV.depth) {
                rootU.parent = rootV;
            } else if(rootU.depth > rootV.depth) {
                rootV.parent = rootU;
            } else {
                rootU.parent = rootV;
                rootV.depth++;
            }
        }
    }
    
    private static class Edge {
        private final int u;
        private final int v;
        private final int cost;
        
        private Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int totalCost = 0;
        
        Node[] nodes = new Node[n];
        for(int i = 0 ; i < n ; i++) {
            nodes[i] = new Node();
        }
        
        Edge[] edges = new Edge[costs.length];
        for(int i = 0 ; i < costs.length ; i++) {
            edges[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);
        }
        Arrays.sort(edges, Comparator.comparingInt(e -> e.cost));
        
        for(Edge edge : edges) {
            Node u = nodes[edge.u];
            Node v = nodes[edge.v];
            
            if(u.isConnected(v)) continue;
            u.merge(v);
            totalCost += edge.cost;
        }
        
        return totalCost;
    }
}