class Solution {
    public int solution(int[] numbers) {
        int answer = 45;

        // numbers에 없는 숫자의 총 합 구하기
        for(int num : numbers) {
            answer -= num;
        }

        return answer;
    }
}