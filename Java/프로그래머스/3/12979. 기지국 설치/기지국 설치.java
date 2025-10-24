class Solution {
    private int calStations(int start, int end, int answer, int r) {
        final int between = end - start + 1;
            
        answer += between / r;
        if(between % r != 0) answer++;
        
        return answer;
    }
    
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        final int length = stations.length;
        final int r = w * 2 + 1;
        
        if(length == 0) return calStations(1, n, answer, r);
        
        int start = 1;
        int end = 0;
        
        for(int i = 0 ; i < length ; i++) {
            final int position = stations[i];
            end = position - w - 1;
            
            if (start <= end) {
                answer = calStations(start, end, answer, r);
            }
            
            start = position + w + 1;
        }
        
        if(start <= n) answer = calStations(start, n, answer, r);

        return answer;
    }
}