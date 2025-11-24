import java.util.*;

class Solution {
    private class Position {
        int x;
        int y;
        
        private Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        private boolean move(String d) {
            switch(d) {
                case "U":
                    if(y >= 5) return false;
                    y++;
                    break;
                case "D":
                    if(y <= -5) return false;
                    y--;
                    break;
                case "R":
                    if(x >= 5) return false;
                    x++;
                    break;
                case "L":
                    if(x <= -5) return false;
                    x--;
                    break;
            }
            return true;
        }
    }
    
    public int solution(String dirs) {
        int answer = 0;
        
        String[] dArr = dirs.split("");
        Position position = new Position(0, 0);
        Set<String> record = new HashSet<>();
        
        for(String d : dArr) {
            Position temp = new Position(position.x, position.y);
            
            if(position.move(d)) {
                String m = "";
                if(temp.x < position.x || (temp.x == position.x && temp.y <= position.y)) {
                    m = "" + temp.x + temp.y + position.x + position.y; 
                } else {
                    m = "" + position.x + position.y + temp.x + temp.y; 
                }
                
                record.add(m);
            }
        }
        
        answer = record.size();
        
        return answer;
    }
}