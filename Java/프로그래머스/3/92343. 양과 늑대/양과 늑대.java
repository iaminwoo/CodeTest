import java.util.*;

class Solution {
    int maxSheep = 0;
    
    private void dfs(int curr, int sheep, int wolf, int[] info, List<Integer> nextNodes, List<Integer>[] graph) {
        if (info[curr] == 0) sheep++;
        else wolf++;
        
        if (wolf >= sheep) return;
        
        maxSheep = Math.max(maxSheep, sheep);
        
        List<Integer> list = new ArrayList<>(nextNodes);
        for (int child : graph[curr]) {
            list.add(child);
        }
        
        for (int i = 0 ; i < list.size() ; i++) {
            int next = list.get(i);
            
            List<Integer> nextList = new ArrayList<>(list);
            nextList.remove(i);
            
            dfs(next, sheep, wolf, info, nextList, graph);
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        List<Integer>[] graph = new ArrayList[info.length];
        for (int i = 0 ; i < info.length ; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        
        List<Integer> nextNodes = new ArrayList<>();
        
        dfs(0, 0, 0, info, nextNodes, graph);
        
        return maxSheep;
    }
}