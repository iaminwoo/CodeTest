import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] maxs = new int[stones.length - k + 1];
        
        for(int i = 0 ; i < k ; i++) {
            while(!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) {
                deque.removeLast();
            }
            
            deque.addLast(i);
        }
        maxs[0] = stones[deque.peekFirst()];
        
        for(int i = 1 ; i <= stones.length - k ; i++) {
            if(deque.peekFirst() < i) {
                deque.removeFirst();
            }
            
            int newIdx = i + k - 1;
            
            while(!deque.isEmpty() && stones[deque.peekLast()] <= stones[newIdx]) {
                deque.removeLast();
            }
            
            deque.addLast(newIdx);
            
            maxs[i] = stones[deque.peekFirst()];
        }
        
        int answer = Integer.MAX_VALUE;
        for(int m : maxs) {
            answer = Math.min(m, answer);
        }
        
        return answer;
    }
}