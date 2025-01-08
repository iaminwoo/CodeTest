class Solution {
    public String solution(int n) {
        String answer = "";

        // 수박수박수박수박
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        while (n >= count) {
            if(count++ % 2 == 0){
                stringBuilder.append("박");
            } else {
                stringBuilder.append("수");
            }
        }
        answer = stringBuilder.toString();

        return answer;
    }
}