import java.util.*;

class Solution {
    private int[] ds;
    private int[] ts;
    private long l;
    private int length;
    
    private boolean isPossible(int level) {
        long sum = 0;
        int prev = 0;
        
        for (int i = 0 ; i < length ; i++) {
            int diff = ds[i];
            int cur = ts[i];
            int before = level >= diff ? 0 : (cur + prev) * (diff - level);
            sum += before + cur;
            
            if (sum > l) {
                return false;
            }
            
            prev = cur;
        }
        
        return sum <= l;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        ds = diffs;
        ts = times;
        l = limit;
        length = diffs.length;
        
        int min = 1;
        int max = 1;
        for (int i = 0 ; i < length ; i++) {
            max = Math.max(max, diffs[i]);
        }
        
        int answer = max;
        
        while(min <= max) {
            int level = (min + max) / 2;
            if (isPossible(level)) {
                // 레벨 낮추기
                answer = level;
                max = level - 1;
            } else {
                // 레벨 올리기
                min = level + 1;
            }
        }
        
        return answer;
    }
}