import java.util.*;

public class Solution {
    public int solution(String s) {
        generate("");
        return array.indexOf(s);
    }

    private final List<String> array = new ArrayList<>();
    private final char[] vowels = new char[] {'A', 'E', 'I', 'O', 'U'};

    private void generate(String s) {
        array.add(s);

        if(s.length() == 5) return;

        for(char c : vowels) {
            generate(s + c);
        }
    }
}