import java.util.*;

public class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s2+s1).compareTo(s1+s2))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString()
                .replaceAll("^0+", "0");
    }
}