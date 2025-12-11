class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        double[] dArr = new double[]{(double)3 / 2, 2, (double)2/3, (double)4/3, (double)1/2, (double)3/4};
        
        int[] exists = new int[2001];
        for (int w : weights) {
            exists[w] += 1;
        }
        
        for (int w : weights) {
            if (exists[w] >= 2) answer += exists[w] - 1;
            
            for (double d : dArr) {
                if ((w * d) % 1 == 0) {
                    answer += exists[(int) (w * d)];
                }
            }
        }
        
        return answer / 2;
    }
}