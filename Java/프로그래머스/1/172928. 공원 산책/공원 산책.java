class Solution {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    
    private int[] getStart(String[] park) {
        for (int x = 0 ; x < park.length ; x++) {
            for (int y = 0 ; y < park[0].length() ; y++) {
                if (park[x].charAt(y) == 'S') return new int[]{x, y};
            }
        }
        return new int[2];
    }
    
    private int getDir(String dir) {
        switch (dir) {
            case "N" : return 0;
            case "S" : return 1;
            case "W" : return 2;
            case "E" : return 3;
            default: return -1;
        }
    }
    
    public int[] solution(String[] park, String[] routes) {
        int[] pos = getStart(park);
        int x = pos[0];
        int y = pos[1];
        
        for (String r : routes) {
            String[] parts = r.split(" ");
            int dir = getDir(parts[0]);
            int dis = Integer.parseInt(parts[1]);
            
            int newX = x + (dx[dir] * dis);
            int newY = y + (dy[dir] * dis);
            
            if (newX < 0 || newX >= park.length || newY < 0 || newY >= park[0].length()) continue;
            
            boolean canPass = true;
            for (int a = Math.min(x, newX) ; a <= Math.max(x, newX) ; a++) {
                for (int b = Math.min(y, newY) ; b <= Math.max(y, newY) ; b++) {
                    if (park[a].charAt(b) == 'X') {
                        canPass = false;
                        break;
                    }
                }
                if (!canPass) break;
            }
            if (!canPass) continue;
            
            x = newX;
            y = newY;
        }
        
        return new int[]{x, y};
    }
}