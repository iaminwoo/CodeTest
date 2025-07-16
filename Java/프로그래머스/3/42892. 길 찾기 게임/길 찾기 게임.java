import java.util.*;

class Solution {
    private class Node {
        int num;
        int x;
        int y;
        
        Node left;
        Node right;
        
        private Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for(int i = 0 ; i < nodeinfo.length ; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        Arrays.sort(nodes, (a,b) -> b.y - a.y);
        
        makeTree(nodes);
        
        List<Integer> preorder = new ArrayList<>();
        pre(nodes[0], preorder);
        
        List<Integer> postorder = new ArrayList<>();
        post(nodes[0], postorder);
        
        int[][] answer = new int[2][];
        answer[0] = preorder.stream().mapToInt(i -> i).toArray();
        answer[1] = postorder.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
    
    private void makeTree(Node[] nodes) {
        Node root = nodes[0];
        
        for(int i = 1 ; i < nodes.length ; i++) {
            insert(nodes[i], root);
        }
    }
    
    private void insert(Node node, Node root){
        if(root.x < node.x) {
            // right
            if(root.right == null) {
                root.right = node;
            } else {
                insert(node, root.right);
            }
        } else {
            // left
            if(root.left == null) {
                root.left = node;
            } else {
                insert(node, root.left);
            }
        }
    }
    
    private void pre(Node node, List<Integer> visitList) {
        if(node == null) return;
        
        visitList.add(node.num);
        
        pre(node.left, visitList);
        pre(node.right, visitList);
    }
    
    private void post(Node node, List<Integer> visitList) {
        if(node == null) return;
        
        post(node.left, visitList);
        post(node.right, visitList);
        
        visitList.add(node.num);
    }
}