class Solution {
    public int solution(int a, int b, boolean flag) {
        int answer = 0;

        // flag 에 따라서 더하기, 빼기
        answer = flag ? a + b : a - b;

        return answer;
    }
}