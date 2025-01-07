class Solution {
    public String solution(String s) {
        String answer = "";

        // s의 중간 글자 반환
        double index = (double) (s.length() + 1) / 2;
        answer = s.substring((int) Math.round(index - 1.5), (int) Math.round(index + 0.4));

        return answer;
    }
}