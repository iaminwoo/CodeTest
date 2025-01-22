class Solution {
    public int solution(int number, int n, int m) {
        int answer = 0;

        // number 가 n 의 배수이면서 m 의 배수인가?
        if(number % n == 0 && number % m == 0) answer = 1;

        return answer;
    }
}