class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        int count = 0;
        double[] dp = new double[200];
        int idx = 0;
        
        while (k > 1) {
            int temp = k;
            count++;
            idx++;
            
            if (k % 2 == 0) {
                k = k / 2;
            } else {
                k = k * 3 + 1;
            }
            
            if (count == 1) {
                dp[idx] = (double) (temp + k) / 2;
            } else {
                dp[idx] = dp[idx - 1] + (double) (temp + k) / 2;
            }
        }
        
        for (int i = count ; i < 200 ; i++) {
            dp[i] = dp[count];
        }
        
        int j = 0;
        for (int[] r : ranges) {
            int a = r[0];
            int b = count + r[1];
            
            if (a > b) {
                answer[j++] = -1;
                continue;
            }
            
            answer[j++] = dp[b] - dp[a];
        }
        
        return answer;
    }
}