class Solution {
    public String solution(String myString) {
        String answer = "";

        // A를 제외한 나머지 소문자로
        myString = myString.toLowerCase().replaceAll("a","A");
        answer = myString;

        return answer;
    }
}