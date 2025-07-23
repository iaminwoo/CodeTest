import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int[] numbers = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();
        
        Stack<Integer> stack = new Stack<>();
        stack.add(numbers[0]);
        
        for(int i = 1 ; i < numbers.length ; i++){
            while(k > 0 && !stack.isEmpty() && stack.peek() < numbers[i]) {
                stack.pop();
                k--;
            }
            
            stack.add(numbers[i]);
        }
        
        while(stack.size() > numbers.length - k) stack.pop();
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}