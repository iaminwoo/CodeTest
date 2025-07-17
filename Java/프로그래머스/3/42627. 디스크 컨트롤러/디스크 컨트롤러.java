import java.util.*;

class Solution {
    private static class Job {
        private int start;
        private int duration;
        
        private Job(int s, int d) {
            start = s;
            duration = d;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        int n = jobs.length;
        
        Job[] jobArray = new Job[n];
        
        for(int i = 0 ; i < n ; i++) {
            jobArray[i] = new Job(jobs[i][0], jobs[i][1]);
        }
        
        Arrays.sort(jobArray, Comparator.comparing(j -> j.start));
        
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> a.duration - b.duration);
        Queue<Job> q = new LinkedList<>();
        
        for(Job job : jobArray) {
            q.add(job);
        }
        
        int now = 0;
        int sum = 0;
        
        while(!q.isEmpty() || !pq.isEmpty()) {
            while(!q.isEmpty() && q.peek().start <= now) {
                pq.add(q.poll());
            }
            
            if(pq.isEmpty()) {
                now = q.peek().start;
                continue;
            }
            
            Job job = pq.poll();
            sum += now - job.start + job.duration;
            now += job.duration;
        }
        
        answer = (int) sum / n;
        
        return answer;
    }
}