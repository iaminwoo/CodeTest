import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        int count = 0;
        double[] dp = new double[200];
        int idx = 0;
        
        while (k > 1) {
            int temp = k;
            count++;
            
            if (k % 2 == 0) {
                k = k / 2;
            } else {
                k = k * 3 + 1;
            }
            
            dp[idx++] = (double) (temp + k) / 2;
        }
        
        int i = 0;
        for (int[] r : ranges) {
            int a = r[0];
            int b = count + r[1];
            
            if (a > b) {
                answer[i++] = -1;
                continue;
            }
            
            double sum = 0;
                        
            for (int j = a ; j < b ; j++) {
                sum += dp[j];
            }
            
            answer[i++] = sum;
        }
        
        return answer;
    }
}