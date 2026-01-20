import java.util.*;

class Solution {
    private String[][] getStorage(String[] s) {
        String[][] storage = new String[la + 2][lb + 2];
        
        Arrays.fill(storage[0], "0");
        Arrays.fill(storage[la + 1], "0");
        
        for (int i = 0 ; i < la ; i++) {
            String row = "0" + s[i] + "0";
            
            String[] r = row.split("");
            storage[i + 1] = r;
        }

        return storage;
    }
    
    private void forklift(String s) {
        for (int i = 1 ; i < la + 1 ; i++) {
            for (int j = 1 ; j < lb + 1 ; j++) {
                if (isOpen(i, j) && storage[i][j].equals(s)) {
                    storage[i][j] = "1";
                }
            }
        }
        
        for (int i = 1 ; i < la + 1 ; i++) {
            for (int j = 1 ; j < lb + 1 ; j++) {
                if (isOpen(i, j) && storage[i][j].equals("1")) {
                    storage[i][j] = "0";
                }
            }
        }
    }
    
    private boolean isOpen(int i, int j) {
        if (open[i - 1][j]) return true;
        if (open[i + 1][j]) return true;
        if (open[i][j - 1]) return true;
        if (open[i][j + 1]) return true;
        return false;
    }
    
    private void crane(String s) {
        for (int i = 1 ; i < la + 1 ; i++) {
            for (int j = 1 ; j < lb + 1 ; j++) {
                if (storage[i][j].equals(s)) {
                    storage[i][j] = "1";
                }
            }
        }
        
        for (int i = 1 ; i < la + 1 ; i++) {
            for (int j = 1 ; j < lb + 1 ; j++) {
                if (storage[i][j].equals("1")) {
                    storage[i][j] = "0";
                }
            }
        }
    }
    
    private int count() {
        int left = 0;
        for (int i = 1 ; i < la + 1 ; i++) {
            for (int j = 1 ; j < lb + 1 ; j++) {
                if (!storage[i][j].equals("0")) {
                    left++;
                }
            }
        }
        return left;
    }
    
    private int[] da = {-1, 1, 0, 0};
    private int[] db = {0, 0, -1, 1};
    
    private void checkOpen() {
        boolean[][] visited = new boolean[la + 2][lb + 2];
        
        open[0][0] = true;
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int a = cur[0];
            int b = cur[1];
            
            for (int i = 0 ; i < 4 ; i++) {
                int newA = a + da[i];
                int newB = b + db[i];
                
                if (newA >= 0 && newA < la + 2 && newB >= 0 && newB < lb + 2) {
                    if (visited[newA][newB]) continue;
                    
                    if (!storage[newA][newB].equals("0")) continue;
                    
                    visited[newA][newB] = true;
                    open[newA][newB] = true;
                    q.offer(new int[]{newA, newB});
                }
            }
        }
    }
    
    private int la;
    private int lb;
    private String[][] storage;
    private boolean[][] open;
    
    public int solution(String[] s, String[] requests) {
        la = s.length;
        lb = s[0].length();
        
        storage = getStorage(s);
        open = new boolean[la + 2][lb + 2];
        checkOpen();
        
        for (String request : requests) {
            if (request.length() == 1) {
                forklift(request);
            } else {
                crane("" + request.charAt(0));
            }
            checkOpen();
        }
                
        return count();
    }
}