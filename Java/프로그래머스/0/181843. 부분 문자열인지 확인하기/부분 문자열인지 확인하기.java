class Solution {
    public int solution(String my_string, String target) {
        int answer = 0;

        // is 부분 문자열
        if(my_string.contains(target)){
            answer = 1;
        }

        return answer;
    }
}