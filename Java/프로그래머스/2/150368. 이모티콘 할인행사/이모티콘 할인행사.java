import java.util.*;

class Solution {
    private void parseUsers(int[][] users) {
        for (int[] u : users) {
            int sale = u[0];
            if (sale > 30) u[0] = 40;
            else if (sale > 20) u[0] = 30;
            else if (sale > 10) u[0] = 20;
            else u[0] = 10;
        }
        
        Arrays.sort(users, (a, b) -> Integer.compare(b[0], a[0]));
        
        parsedUsers = users;
    }
    
    private int[][] parsedUsers;
    private int[] answers = new int[2];
    
    private void getResults(int index, int[] emoticons, int[] result) {
        if (index == emoticons.length) {
            int plus = 0;
            int totalSum = 0;
            for (int[] user : parsedUsers) {
                int minDiscount = user[0];
                int sum = 0;
                for (int i = 0 ; i < emoticons.length ; i++) {
                    int discount = result[i];
                    if (minDiscount <= discount) {
                        sum += (emoticons[i] / 100) * (100 - discount);
                    }
                }
                
                if (sum >= user[1]) {
                    sum = 0;
                    plus++;
                }
                
                totalSum += sum;
            }
            
            if (plus >= answers[0]) {
                if (plus > answers[0]) {
                    answers[1] = totalSum;
                } else {
                    answers[1] = Math.max(answers[1], totalSum);
                }
                answers[0] = plus;
            }
            
            return;
        }
        
        for (int discount = 10 ; discount <= 40 ; discount += 10) {
            result[index] = discount;
            getResults(index + 1, emoticons, result);
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        parseUsers(users);
        
        int[] result = new int[emoticons.length];
        getResults(0, emoticons, result);
        
        answer[0] = answers[0];
        answer[1] = answers[1];
        
        return answer;
    }
}