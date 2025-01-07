class Solution {
    public String solution(String myString) {
        String answer = "";

        // "l" 보다 앞서는 알파벳 "l"로 바꾸기
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < myString.length() ; i++) {
            if(myString.charAt(i) < 'l') {
                stringBuilder.append('l');
            } else {
                stringBuilder.append(myString.charAt(i));
            }
        }
        answer = stringBuilder.toString();

        return answer;
    }
}