import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0 ; i < 24 ; i++) {
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            
            int p = players[i];
            int need = p / m;
            
            if (!pq.isEmpty()) {
                if (need <= pq.size()) continue;
            
                need = need - pq.size();
            }
            
            for (int j = 0 ; j < need ; j++) {
                pq.add(i + k - 1);
            }
            
            answer += need;
        }
        
        return answer;
    }
}