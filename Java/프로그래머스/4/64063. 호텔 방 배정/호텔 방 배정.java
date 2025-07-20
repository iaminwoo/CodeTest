import java.util.*;

class Solution {
    private static class Node {
        private int depth = 0;
        private Node parent = null;
        private long max;
        
        private Node(long num) {
            this.max = num;
        }
        
        private void merge(Node v) {
            if(isConnected(v)) return;
            
            Node rootU = root();
            Node rootV = v.root();
            
            if(rootU.depth < rootV.depth) {
                rootU.parent = rootV;
            } else if(rootU.depth > rootV.depth) {
                rootV.parent = rootU;
            } else {
                rootV.parent = rootU;
                rootU.depth++;
            }
            
            rootV.max = rootU.max = Math.max(rootV.max, rootU.max);
        }
        
        private boolean isConnected(Node v) {
            return root() == v.root();
        }
        
        private Node root() {
            if(this.parent == null) return this;
            return this.parent = this.parent.root();
        }
        
        private long max() {
            return root().max;
        }
    }
    
    public long[] solution(long k, long[] room_number) {
        List<Long> answer = new ArrayList<>();
        
        Map<Long, Node> nodes = new HashMap<>();
        
        for(long num : room_number) {
            if(nodes.keySet().contains(num)) {
                num = nodes.get(num).max() + 1;
            }
            
            Node node = new Node(num);
            nodes.put(num, node);
            
            if(nodes.keySet().contains(num - 1)) {
                node.merge(nodes.get(num - 1));
            }
            
            if(nodes.keySet().contains(num + 1)) {
                node.merge(nodes.get(num + 1));
            }
            
            answer.add(num);
        }
        
        return answer.stream().mapToLong(i -> i).toArray();
    }
}