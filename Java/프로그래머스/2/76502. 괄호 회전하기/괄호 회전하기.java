import java.util.*;

class Solution {
    private boolean isValid(int i, String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int j = i; j < s.length() + i; j++) {
            char c = s.charAt(j % s.length());
            
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (isValid(i, s)) answer++;
        }
        
        return answer;
    }
}
