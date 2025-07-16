class Solution {
    private int countForward(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;
        isVisited[u] = true;
        
        for(int v = 0 ; v < graph[u].length ; v++) {
            if(!graph[u][v] || isVisited[v]) continue;
            count += countForward(v, graph, isVisited);
        }
        
        return count;
    }
    
    private int countBackward(int u, boolean[][] graph, boolean[] isVisited) {
        int count = 1;
        isVisited[u] = true;
        
        for(int v = 0 ; v < graph[u].length ; v++) {
            if(!graph[v][u] || isVisited[v]) continue;
            count += countBackward(v, graph, isVisited);
        }
        
        return count;
    }
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] graph = new boolean[n][n];
        for(int[] result : results) {
            int u = result[0] - 1;
            int v = result[1] - 1;
            graph[u][v] = true;
        }
        
        for(int u = 0 ; u < n ; u++) {
            if(countForward(u, graph, new boolean[n])
              + countBackward(u, graph, new boolean[n])
              -1 == n) answer++;
        }
        
        return answer;
    }
}