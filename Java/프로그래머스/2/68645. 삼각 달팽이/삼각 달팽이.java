public class Solution {
    public int[] solution(int n) {
        int[][] square = new int[n][n];

        final int[] dx = {0, 1, -1};
        final int[] dy = {1, 0, -1};

        int x = 0;
        int y = 0;
        int d = 0;
        int v = 1;

        while (true) {
            square[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(ny == n || nx == n || square[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if(ny == n || nx == n || square[ny][nx] != 0) break;
            }
            x = nx;
            y = ny;
        }

        int index = 0;
        int[] result = new int[v - 1];
        for (int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j <= i ; j++) {
                result[index++] = square[i][j];
            }
        }

        return result;
    }
}
