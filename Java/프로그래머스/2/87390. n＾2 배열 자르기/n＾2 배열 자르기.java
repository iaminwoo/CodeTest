class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        
        long l1 = (left + 1) / n + 1;
        long l2 = (left + 1) % n;
        if(l2 == 0) {
            l1 -= 1;
            l2 = n;
            }
        long r1 = (right + 1) / n + 1;
        long r2 = (right + 1) % n;
        if(r2 == 0) {
            r1 -= 1;
            r2 = n;
        }
        
        int idx = 0;
        for(long i = l1 ; i <= r1 ; i++) {
            long start = (i == l1) ? l2 : 1;
            long end = (i == r1) ? r2 : n;
            for(; start <= end ; start++) {
                answer[idx++] = i >= start ? (int) i : (int) start;
            }
        }
        
        return answer;
    }
}