class Solution {
    public String solution(String[] str_list, String ex) {
        String answer = "";

        // 배열에서 ex 포함하는 문자열은 제외하고 반환
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : str_list) {
            if(!s.contains(ex)) {
                stringBuilder.append(s);
            }
        }
        answer = stringBuilder.toString();

        return answer;
    }
}