import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";

        int[] parts = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        answer = parts[0] + " " + parts[parts.length-1];

        return answer;
    }
}