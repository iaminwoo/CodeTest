public class Solution {
    private static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(String[][] places) {
        int[] result = new int[places.length];
        int index = 0;

        for(String[] place : places) {
            result[index++] = check(place)? 1 : 0;
        }

        return result;
    }

    private boolean check(String[] place) {
        char[][] room = new char[place.length][place[0].length()];
        for (int i = 0 ; i < place.length ; i++) {
            room[i] = place[i].toCharArray();
        }

        for(int i = 0 ; i < room.length ; i++) {
            for(int j = 0 ; j < room[0].length ; j++) {
                if(room[i][j] == 'P') {
                    if(!checkDistance(room, new Point(j, i))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkDistance(char[][] room, Point point) {
        final int[] dx = {0, 0, -1, 1};
        final int[] dy = {1, -1, 0, 0};

        for (int d = 0 ; d < 4 ; d++) {
            int nx = point.x + dx[d];
            int ny = point.y + dy[d];

            if(nx < 0 || nx >= room.length || ny < 0 || ny >= room.length) continue;

            if(room[ny][nx] == 'P') return false;

            if(room[ny][nx] != 'X') {
                for(int nd = 0 ; nd < 4 ; nd++) {
                    int nnx = nx + dx[nd];
                    int nny = ny + dy[nd];

                    if(nnx == point.x && nny == point.y) continue;
                    if(nnx < 0 || nnx >= room.length || nny < 0 || nny >= room.length) continue;

                    if(room[nny][nnx] == 'P') return false;
                }
            }
        }

        return true;
    }
}