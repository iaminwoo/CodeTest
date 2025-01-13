class Solution {
    public int solution(int n) {
        int answer = 0;

        // 홀 : n 이하 홀수 합, 짝 : n 이하 짝수 제곱 합
        int pow = n % 2 == 0 ? 2 : 1;
        for(int i = pow ; i <= n ; i += 2) {
            answer += (int) Math.pow(i, pow);
        }

        return answer;
    }
}