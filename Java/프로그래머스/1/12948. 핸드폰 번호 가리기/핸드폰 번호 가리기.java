class Solution {
    public String solution(String phone_number) {
        String answer = "";

        // 전화번호 뒷자리 4자만 남기기
        answer = "*".repeat(phone_number.length() - 4) +
                phone_number.substring(phone_number.length() - 4);

        return answer;
    }
}