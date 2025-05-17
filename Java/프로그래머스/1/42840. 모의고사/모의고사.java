import java.util.*;

class Solution {
    private static final int[][] RULES = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    
    private int picked(int person, int number) {
        return RULES[person][number % RULES[person].length];
    }
    
    public int[] solution(int[] answers) {
        int[] answer = {};
        int max = Integer.MIN_VALUE;
        int[] score = new int[3];
        
        for (int i = 0 ; i < answers.length ; i++) {
            for(int person = 0 ; person < RULES.length ; person++) {
                if(answers[i] == picked(person, i)) {
                    score[person]++;
                    
                    if(max < score[person]) max = score[person];
                }
            }
        }
        
        List<Integer> best = new ArrayList<>();
        for(int person = 0 ; person < RULES.length ; person++) {
            if(max == score[person]) {
                best.add(person + 1);
            }
        }
        answer = best.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}