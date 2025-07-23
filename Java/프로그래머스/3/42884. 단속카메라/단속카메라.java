import java.util.*;

class Solution {
    private boolean isCaught(int[] route, int camera) {
        return route[0] <= camera && camera <= route[1];
    }
    
    public int solution(int[][] routes) {
        List<Integer> cameras = new ArrayList<>();
        
        for(int[] route : routes) {
            route[0] = Math.min(route[0], route[1]);
            route[1] = Math.max(route[0], route[1]);
        }
        
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        
        for(int[] route : routes) {
            boolean caught = false;
            for(int camera : cameras) {
                if(isCaught(route, camera)) {
                    caught = true;
                    break;
                }
            }
            
            if(!caught) {
                cameras.add(route[1]);
            }
        }
        
        return cameras.size();
    }
}