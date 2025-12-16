import java.util.*;

class Solution {
    public int solution(int[] a) {
        int l = a.length;
        if (l <= 2) return l;
        
        int answer = 2;
        
        int[] rightMinArr = new int[l];
        rightMinArr[l - 1] = a[l - 1];
        
        for (int i = l - 2; i >= 0; i--) {
            rightMinArr[i] = Math.min(a[i], rightMinArr[i + 1]);
        }
        
        int leftMin = a[0];
        
        for (int i = 1; i < l - 1; i++) {
            int n = a[i];
            int rightMin = rightMinArr[i + 1];
            
            if (leftMin > n || rightMin > n) {
                answer++;
            }
            
            leftMin = Math.min(leftMin, n);
        }

        return answer;
    }
}