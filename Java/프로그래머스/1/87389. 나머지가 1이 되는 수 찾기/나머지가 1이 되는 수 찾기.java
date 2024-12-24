class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // n을 answer로 나눈 나머지가 1
        for(int i = 1 ; i < n ; i++) {
            if(n % i == 1) return i;
        }
        
        return answer;
    }
}