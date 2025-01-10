class Solution {
    public boolean solution(String s) {
        boolean answer = true;

        // s 의 길이가 4 또는 6, 숫자로만 구성?
        answer = false;
        if(s.length() == 4 || s.length() == 6) {
            if(s.matches("[0-9]+")){
                answer = true;
            }
        }

        return answer;
    }
}