class Solution {
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};
    
    private boolean checkIfOk(int y, int x, String[][] room) {
        int d = 0;
        
        for(int i = 0 ; i < 4 ; i++) {
            int newY = y + dy[i];
            if(newY < 0 || newY > 4) continue;
            int newX = x + dx[i];
            if(newX < 0 || newX > 4) continue;
            
            String seat = room[newY][newX];
            
            if(seat.equals("X")) continue;
            
            if(seat.equals("P")) return false;
            
            int e = 0;
            
            for(int j = 0 ; j < 4 ; j++) {
                if(j == (i + 2) % 4) continue;
                
                int newNewY = newY + dy[j];
                if(newNewY < 0 || newNewY > 4) continue;
                int newNewX = newX + dx[j];
                if(newNewX < 0 || newNewX > 4) continue;
                
                if(room[newNewY][newNewX].equals("P")) return false;
            }
        }
        
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0 ; i < 5 ; i++) {
            answer[i] = 1;
            boolean isOk = true;
            String[] room = places[i];
            
            String[][] roomArray = new String[5][5];
            for(int y = 0 ; y < 5 ; y++) {
                String row = room[y];
                for(int x = 0 ; x < 5 ; x++) {
                    roomArray[y][x] = "" + row.charAt(x);
                }
            }
            
            outer:
            for (int y = 0; y < 5; y++) {
                for (int x = 0; x < 5; x++) {
                    if (roomArray[y][x].equals("P")) {
                        if (!checkIfOk(y, x, roomArray)) {
                            answer[i] = 0;
                            break outer;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}