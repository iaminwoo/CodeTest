import java.util.*;

class Solution {
    private static class Com {
        private final int num;
        private final List<Integer> connectedComs = new ArrayList<>();
        
        private Com(int num, int[][] computers) {
            this.num = num;
            
            for(int j = 0 ; j < computers.length ; j++) {
                if(computers[num][j] == 1) connectedComs.add(j);
            }
        }
    }
    
    private int countNetwork(int i, Com[] coms, Set<Integer> visited) {
        if(!visited.contains(i)) {
            visited.add(i);
        
            for(Integer cc : coms[i].connectedComs) {
                countNetwork(cc, coms, visited);
            }
            
            return 1;
        }
        
        return 0;
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        Com[] coms = new Com[n];
        for(int i = 0 ; i < n ; i++) {
            coms[i] = new Com(i, computers);
        }
        
        Set<Integer> visited = new HashSet<>();
        
        for(int i = 0 ; i < n ; i++) {
            answer += countNetwork(i, coms, visited);
        }
        
        return answer;
    }
}