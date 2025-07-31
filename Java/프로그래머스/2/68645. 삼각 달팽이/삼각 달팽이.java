class Solution {
    private static int[] dx = {0, 1, -1};
    private static int[] dy = {1, 0, -1};
    
    public int[] solution(int n) {
        int[][] square = new int[n][n];
        int y = 0;
        int x = 0;
        int d = 0;
        int count = 1;
        int max = (n * n + n) / 2;
        
        square[y][x] = count;
        
        while(count < max) {
            int ny = y + dy[d % 3];
            int nx = x + dx[d % 3];

            if(ny >= 0 && ny < n && nx >= 0 && nx < n && square[ny][nx] == 0) {
                y = ny;
                x = nx;
                square[y][x] = ++count;
            } else {
                d++;
            }
        }

        
        int[] answer = new int[max];
        int index = 0;
        
        for(int[] row : square) {
            for(int num : row) {
                if(num == 0) continue;
                answer[index++] = num;
            }
        }
        
        return answer;
    }
}