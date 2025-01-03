class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 2부터 n 이하로 나눠지는 수
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 2 ; j < i ; j++) {
                if(i % j == 0) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}