import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        String answer = "";

        // 다 소문자로 바꾸고, 정렬
        answer = my_string.toLowerCase()
                .chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        return answer;
    }
}