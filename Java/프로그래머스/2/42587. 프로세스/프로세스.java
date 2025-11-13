import java.util.*;

class Solution {
    private class Process{
        final int priority;
        final int idx;
        
        private Process(int priority, int idx){
            this.priority = priority;
            this.idx = idx;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i = 0 ; i < priorities.length ; i++){
            final int priority = priorities[i];
            
            final Process process = new Process(priority, i);
            
            queue.offer(process);
            pq.offer(priority);
        }
        
        int count = 0;
        int max = pq.poll();
        while(!queue.isEmpty()){
            final Process process = queue.poll();
            
            if(process.priority != max) {
                queue.offer(process);
            } else {
                count++;
                if(process.idx == location) return count;
                max = pq.poll();
            }
        }
        
        return 0;
    }
}