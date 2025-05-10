import java.util.*;

public class Solution {
    public String[] solution(int[][] line) {
        // 1. 두 선의 교점, 정수 체크
        List<Point> points = new ArrayList<>();
        for (int i = 0 ; i < line.length ; i++) {
            for(int j = i + 1 ; j < line.length ; j++) {
                Point point = intersection(line[i], line[j]);
                if (Objects.nonNull(point)) {
                    points.add(point);
                }
            }
        }

        // 2. 너비, 높이 계산
        long[] minMax = getXYMinMax(points);
        long xMax = minMax[0];
        long xMin = minMax[2];
        long yMax = minMax[1];
        long yMin = minMax[3];

        int width = (int) (xMax - xMin + 1);
        int height = (int) (yMax - yMin + 1);
        char[][] stars = new char[height][width];
        for(char[] ca : stars) {
            Arrays.fill(ca, '.');
        }

        // 3. 별 찍기
        for(Point p : points) {
            stars[(int) (yMax - p.y)][(int) (p.x - xMin)] = '*';
        }

        // 4. 결과 반환
        return Arrays.stream(stars)
                .map(String::new)
                .toArray(String[]::new);
    }

    private static class Point{
        final long x;
        final long y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point intersection(int[] lineA, int[] lineB) {
        long den = (long) lineA[0] * lineB[1] - (long) lineA[1] * lineB[0];
        long xNum = (long) lineA[1] * lineB[2] - (long) lineA[2] * lineB[1];
        long yNum = (long) lineA[2] * lineB[0] - (long) lineA[0] * lineB[2];

        if(den == 0 || xNum % den != 0 || yNum % den != 0) return null;

        return new Point(xNum / den, yNum / den);
    }

    private long[] getXYMinMax(List<Point> points) {
        long xMax = Long.MIN_VALUE;
        long yMax = Long.MIN_VALUE;
        long xMin = Long.MAX_VALUE;
        long yMin = Long.MAX_VALUE;

        for (Point p : points) {
            if(p.x > xMax) xMax = p.x;
            if(p.y > yMax) yMax = p.y;
            if(p.x < xMin) xMin = p.x;
            if(p.y < yMin) yMin = p.y;
        }

        return new long[]{xMax, yMax, xMin, yMin};
    }
}