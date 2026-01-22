import java.util.*;

class Solution {
    private int position;
    private Deque<Integer> trash = new ArrayDeque<>();
    private boolean[] removed;
    
    private int[] prev;
    private int[] next;
    
    private void deleteOrRestore(String c) {
        if (c.equals("C")) {
            trash.push(position);
            removed[position] = true;
            
            int p = prev[position];
            int n = next[position];
            
            if (p != -1) next[p] = n;
            if (n != -1) {
                prev[n] = p;
                position = n;
            } else {
                position = p;
            }
        } else {
            // "Z"
            int restored = trash.pop();
            removed[restored] = false;
            int p = prev[restored];
            int n = next[restored];
            
            if (p != -1) next[p] = restored;
            if (n != -1) prev[n] = restored;
        }
    }
    
    private void move(String c) {
        String[] parts = c.split(" ");
        int dist = Integer.parseInt(parts[1]);
        if (parts[0].equals("D")) {
            down(dist);
        } else {
            up(dist);
        }
    }
    
    private void up(int dist) {
        while (dist > 0) {
            position = prev[position];
            dist--;
        }
    }
    
    private void down(int dist) {
        while (dist > 0) {
            position = next[position];
            
            dist--;
        }
    }
    
    public String solution(int n, int k, String[] cmd) {
        position = k;
        removed = new boolean[n];
        
        prev = new int[n];
        next = new int[n];
        for (int i = 0 ; i < n ; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        
        for (String c : cmd) {
            if (c.length() == 1) {
                deleteOrRestore(c);
            } else {
                move(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (boolean r : removed) {
            if (r) {
                sb.append("X");
            } else {
                sb.append("O");
            }
        }
        
        return sb.toString();
    }
}