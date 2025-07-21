import java.util.Stack;

class Solution {
    private static class State {
        private int index;
        private int sum;
        
        private State(int i, int s) {
            this.index = i;
            this.sum = s;
        }
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Stack<State> s = new Stack<>();
        
        s.add(new State(0, 0));
        
        while(!s.isEmpty()) {
            State state = s.pop();
            
            if(state.index == numbers.length) {
                if(state.sum == target) {
                    answer++;
                }
                continue;
            }
            
            s.add(new State(state.index + 1, state.sum - numbers[state.index]));
            s.add(new State(state.index + 1, state.sum + numbers[state.index]));
        }
        
        return answer;
    }
}