class Solution {
    private int maxCount = 0;

    private void dfs(int k, int[][] dungeons, boolean[] visited, int currentCount) {
        maxCount = Math.max(maxCount, currentCount);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                int next_k = k - dungeons[i][1];
                
                dfs(next_k, dungeons, visited, currentCount + 1);
                
                visited[i] = false;
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, visited, 0); 
        
        return maxCount;
    }
}