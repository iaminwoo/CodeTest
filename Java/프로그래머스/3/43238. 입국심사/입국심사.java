class Solution {
    private long processed(long totalTime, int[] times, int n) {
        long sum = 0;
        
        for (int t : times) {
            sum += totalTime / t;
            if (sum >= n) return sum;
        }
        
        return sum;
    }
    
    public long solution(int n, int[] times) {
        
        long left = 1;
        long right = 1_000_000_000_000_000_000L;
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            
            if (processed(mid, times, n) >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        long answer = right;
        return answer;
    }
}