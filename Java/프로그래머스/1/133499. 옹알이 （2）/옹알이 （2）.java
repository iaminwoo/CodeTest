class Solution {
    final String[] oks = {"aya", "ye", "woo", "ma"};
    
    private boolean canSpeak(String word) {
        for (int i = 0 ; i < oks.length ; i++) {
            word = word.replace(oks[i], "" + i);
        }
        
        char last = 'A';
        
        for (int i = 0 ; i < word.length() ; i++) {
            char c = word.charAt(i);
            if (!Character.isDigit(c) || c == last) return false;
            last = c;
        }
        
        return true;
    }
    
    public int solution(String[] babbling) {
        final int l = babbling.length;
        
        int answer = 0;
        
        for (String word : babbling) {
            if (canSpeak(word)) answer++;
        }
        
        return answer;
    }
}