import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        final int totalDays = score.length;
        final int[] answer = new int[totalDays];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0;
        
        for(int day = 0 ; day < totalDays ; day++) {
            pq.offer(score[day]);
            
            if(pq.size() > k) pq.poll();
            
            answer[day] = pq.peek();
        }
        
        return answer;
    }
}