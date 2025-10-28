class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int paint = 0;
        for(int i = 0 ; i < section.length ; i++) {
            if(paint >= section[i]) continue;
            answer++;
            paint = section[i] + m - 1;
        }
        
        return answer;
    }
}