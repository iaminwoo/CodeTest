import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int nextBox = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        
        while(true) {
            if(nextBox > order.length && stack.isEmpty()) break;
            if(nextBox > order.length && stack.peek() != order[answer]) break;
            
            if(!stack.isEmpty() && stack.peek() == order[answer]) {
                stack.pop();
                answer++;
            } else {
                if(nextBox == order[answer]) {
                    answer++;
                    nextBox++;
                } else {
                    stack.push(nextBox++);
                }
            }
        }
        
        return answer;
    }
}