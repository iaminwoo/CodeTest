class Solution {
    public String solution(String phone_number) {
        final int changeNum = phone_number.length() - 4;
        return "*".repeat(changeNum) + phone_number.substring(changeNum);
    }
}