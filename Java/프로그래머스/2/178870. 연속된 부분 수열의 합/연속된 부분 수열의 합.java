class Solution {
    public int[] solution(int[] sequence, int k) {
        final int l = sequence.length;
        final int[] answer = new int[]{0, l - 1};
        
        int start = 0;
        int end = 0;
        
        int sum = 0;
        for (int i = 0 ; i < l ; i++) {
            sum += sequence[i];
            
            if (sum >= k) {
                end = i;
                break;
            }
        }
        
        while (sequence[end] <= k) {
            if (sum > k) {
                sum -= sequence[start++];
            } else {
                if (sum == k) {
                    if (answer[1] - answer[0] > end - start) {
                        answer[0] = start;
                        answer[1] = end;
                    }
                }

                end++;
                if (end >= l) break;
                sum += sequence[end];
            }
        }
        
        return answer;
    }
}