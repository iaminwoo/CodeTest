import java.util.*;

class Solution {
    private static class Point {
        private final int x;
        private final int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private Point getPoint(int[] lineA, int[] lineB) {
        long xUp  = (long)lineA[1] * lineB[2] - (long)lineA[2] * lineB[1];
        long yUp  = (long)lineA[2] * lineB[0] - (long)lineA[0] * lineB[2];
        long down = (long)lineA[0] * lineB[1] - (long)lineA[1] * lineB[0];

        if (down == 0) return null;

        if (xUp % down == 0 && yUp % down == 0) {
            int x = (int)(xUp / down);
            int y = (int)(yUp / down);
            return new Point(x, y);
        }
        return null;
    }
    
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        int xMin = Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < line.length - 1 ; i++) {
            for(int j = i + 1 ; j < line.length ; j++) {
                Point point = getPoint(line[i], line[j]);
                if(point != null) {
                    points.add(point);
                    if(point.x > xMax) xMax = point.x;
                    if(point.x < xMin) xMin = point.x;
                    if(point.y > yMax) yMax = point.y;
                    if(point.y < yMin) yMin = point.y;
                }
            }
        }
        
        String[][] square = new String[yMax - yMin + 1][xMax - xMin + 1];
        for(String[] row : square) {
            Arrays.fill(row, ".");
        }
        
        for(Point point : points) {
            int x = point.x - xMin;
            int y = yMax - point.y;
            square[y][x] = "*";
        }
        
        StringBuilder sb = new StringBuilder();
        String[] answer = new String[square.length];
        for(int i = 0 ; i < square.length ; i++) {
            for(String s : square[i]) {
                sb.append(s);
            }
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        
        return answer;
    }
}