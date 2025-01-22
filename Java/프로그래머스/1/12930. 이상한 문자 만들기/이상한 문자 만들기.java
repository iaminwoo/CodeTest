class Solution {
    public String solution(String s) {
        String answer = "";

        // 각 문자의 홀짝 대소문자 변환
        s = s.toLowerCase();
        StringBuilder answerSB = new StringBuilder();
        int index = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) != ' ') {
                if(index++ % 2 == 0) {
                    answerSB.append((char)(s.charAt(i) - 32));
                } else {
                    answerSB.append(s.charAt(i));
                }
            } else {
                index = 0;
                answerSB.append(s.charAt(i));
            }
        }
        answer = answerSB.toString();

        return answer;
    }
}