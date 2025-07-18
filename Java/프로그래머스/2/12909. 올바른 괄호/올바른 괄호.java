import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.add(c);
            } else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}