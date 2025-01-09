import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        String answer = "";

        // 문자열 s 큰것부터 작은것으로 정렬
        answer = s
            .chars()
            .mapToObj(c -> String.valueOf((char)c))
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.joining(""));

        return answer;
    }
}