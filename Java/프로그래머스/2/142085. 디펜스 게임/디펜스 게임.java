import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        
        for (int i = 0 ; i < enemy.length ; i++) {
            pq.offer(enemy[i]);
            
            if (pq.size() > k) {
                sum += pq.poll();
                if (sum > n) break;
            }
            
            answer = i + 1;
        }
        
        return answer;
    }
}