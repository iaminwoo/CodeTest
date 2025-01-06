class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";

        // alp 글자 대문자로 바꾸기
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < my_string.length() ; i++) {
            if(my_string.charAt(i) == alp.charAt(0)) {
                stringBuilder.append(String.valueOf(my_string.charAt(i)).toUpperCase());
            } else {
                stringBuilder.append(my_string.charAt(i));
            }
        }
        answer = stringBuilder.toString();

        return answer;
    }
}