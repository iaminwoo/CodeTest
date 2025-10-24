import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        final Set<String> set = new HashSet<>();
        final Deque<String> stack = new ArrayDeque<>();
        stack.push(words[0]);
        set.add(words[0]);
        int count = 1;
        
        boolean repeated = false;
        for(int idx = 1 ; idx < words.length ; idx++) {
            count++;
            String word = words[idx];
            
            String lastWord = stack.peek();
            char lastChar = lastWord.charAt(lastWord.length() - 1);
            
            if(set.contains(word) || word.charAt(0) != lastChar) {
                repeated = true;
                break;
            }
            
            set.add(word);
            stack.push(word);
        }
        
        if(repeated) {
            int num = count % n;
            int turn = count / n + 1;
            if(num == 0) {
                num = n;
                turn--;
            }
            return new int[]{num, turn};
        }
        
        return answer;
    }
}