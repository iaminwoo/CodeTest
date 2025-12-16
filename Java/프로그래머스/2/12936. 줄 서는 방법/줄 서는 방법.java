import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        long[] factorial = new long[n + 1];
        long f = 1;
        for (int i = 1 ; i <= n ; i++) {
            factorial[i] = f = f * i;
            list.add(i);
        }
        
        int[] answer = new int[n];
        int idx = 0;
        
        long num = k;
        long r = 1;
        while (r > 0) {
            r = num % factorial[n - 1];
            
            long m = num / factorial[n - 1];
            if (r > 0) m++;
            
            answer[idx++] = list.remove((int)m - 1);
            
            num = r;
            n--;
            
            if (r == 0) {
                while (!list.isEmpty()) {
                    answer[idx++] = list.remove(list.size() - 1);
                }
                break;
            }
        }
        
        return answer;
    }
}