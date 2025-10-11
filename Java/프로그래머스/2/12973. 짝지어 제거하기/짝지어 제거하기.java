import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            
            if(stack.isEmpty() || c != stack.peek()) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        
        if(stack.isEmpty()) answer = 1;

        return answer;
    }
}