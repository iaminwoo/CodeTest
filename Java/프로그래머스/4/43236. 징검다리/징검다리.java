import java.util.*;

class Solution {
    private boolean isValid(int[] rocks, int mid, int n) {
        int removed = 0;
        int last = 0;
        
        for(int rock : rocks) {
            if(rock - last < mid) {
                removed++;
            } else {
                last = rock;
            }
        }
        
        return removed <= n;
    }
    
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        rocks = Arrays.copyOf(rocks, rocks.length + 1);
        rocks[rocks.length-1] = distance;
        Arrays.sort(rocks);
        
        int start = 1;
        int end = distance + 1;
        
        while(end - start > 1) {
            int mid = (start + end) / 2;
            
            if(isValid(rocks, mid, n)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        answer = start;
        
        return answer;
    }
}