import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int sc : scoville) {
            pq.offer(sc);
        }
        
        while(pq.peek() < K) {
            if(pq.size() == 1) return -1;
            
            answer++;
            
            int a = pq.poll();
            int b = pq.poll();
            int n = a + (b * 2);
            
            pq.offer(n);
        }
        
        return answer;
    }
}