class Solution {
    public int solution(String num_str) {
        int answer = 0;

        // num_str 의 자리수 합
        String[] numParts = num_str.split("");
        for(String num : numParts) answer += Integer.parseInt(num);

        return answer;
    }
}