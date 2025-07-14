class Solution {
    private boolean isValid(long mid, int n, int[] times) {
        long sum = 0;
        
        for (int t : times) {
            sum += mid / t;
        }
        
        return sum >= n;
    }
    
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long start = 1;
        long end = 1000000000000000000L;
        
        while (end > start) {
            long mid = (start + end) / 2;
            
            if(isValid(mid, n, times)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        answer = start;
        
        return answer;
    }
}