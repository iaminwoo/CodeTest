import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0 ; i < works.length ; i++) {
            pq.offer(works[i]);
        }
        
        while(n > 0) {
            int max = pq.poll();
            if(max <= 0) {
                pq.offer(max);
                break;
            }
            pq.offer(max - 1);
            n--;
        }
        
        while(pq.peek() != null) {
            int num = pq.poll();
            answer += num * num;
        }
        
        return answer;
    }
}