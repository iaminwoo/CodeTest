public class Solution {
    public int solution(String s) {
        count = 0;
        found = false;
        count("", s);
        return count;
    }

    private int count;
    private final char[] vowels = new char[] {'A', 'E', 'I', 'O', 'U'};
    private boolean found;

    private void count(String word, String s) {
        if(s.equals(word)) {
            found = true;
            return;
        }

        if(found) return;
        count++;

        if(word.length() == 5) return;

        for(char c : vowels) {
            count(word + c, s);
        }
    }
}