class Solution {
    public long solution(int a, int b) {
        long answer = 0;

        // a와 b 사이 정수 값 더해서 반환
        for(int i = Math.min(a,b) ; i <= Math.max(a,b) ; i++) {
            answer += i;
        }

        return answer;
    }
}