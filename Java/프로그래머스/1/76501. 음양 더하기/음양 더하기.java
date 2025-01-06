class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 123456789;

        // 절댓값과 부호를 가지고 정수들의 합 구하기
        int sum = 0;
        for(int i = 0 ; i < absolutes.length ; i++) {
            if(signs[i]) {
                sum += absolutes[i];
            } else {
                sum -= absolutes[i];
            }
        }
        answer = sum;

        return answer;
    }
}