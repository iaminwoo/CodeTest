class Solution {
    public int solution(int a, int b) {
        int answer = 0;

        // 주사위 a, b : 둘다 홀수라면 a^2 + b^2 점, 하나만 홀수 2 × (a + b) 점, 둘다 짝수 |a - b| 점
        if( (a + b) % 2 != 0) {
            // a, b 둘 중 하나만 홀수인 경우
            answer = 2 * (a + b);
        } else {
            if(a % 2 == 0) {
                // 둘다 짝수인 경우
                answer = Math.abs(a - b);
            } else {
                // 둘다 홀수인 경우
                answer = a * a + b * b;
            }
        }

        return answer;
    }
}