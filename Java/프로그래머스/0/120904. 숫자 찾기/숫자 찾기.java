class Solution {
    public int solution(int num, int k) {
        int answer = -1;

        // num 안에 k의 자릿수 확인
        int check = 0;
        while (num > 0) {
            check++;
            if(num % 10 == k) {
                answer = check;
            }
            num /= 10;
        }
        if(answer != -1) answer = check - answer + 1;

        return answer;
    }
}