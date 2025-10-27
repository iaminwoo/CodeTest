import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        final int length = elements.length;
        final Set<Integer> set = new HashSet<>();
        
        for(int start = 0; start < length ; start++) {
            int num = 0;
            for(int end = 0 ; end < length ; end++) {
                num += elements[(start + end) % length];
                set.add(num);
            } 
        }
        
        return set.size();
    }
}