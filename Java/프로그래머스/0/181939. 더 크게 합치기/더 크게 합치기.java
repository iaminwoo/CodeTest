class Solution {
    public int solution(int a, int b) {
        int answer = 0;

        // 연산 ⊕ : 두 정수 붙여서 출력
        answer = Math.max(Integer.parseInt("" + a + b), Integer.parseInt("" + b + a));

        return answer;
    }
}