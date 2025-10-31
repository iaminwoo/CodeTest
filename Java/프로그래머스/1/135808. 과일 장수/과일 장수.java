import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int s : score) pq.offer(s);
        
        while(true) {
            if(pq.size() >= m) {
                PriorityQueue<Integer> smallest = new PriorityQueue<>();
                
                for(int i = 0 ; i < m ; i++) smallest.offer(pq.poll());
                
                answer += smallest.poll() * m;
            } else {
                break;
            }
        }
        
        return answer;
    }
}