import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int l = sequence.length;
        
        long[] s1 = new long[l];
        long[] s2 = new long[l];
        
        for (int i = 0 ; i < l ; i++) {
            if (i % 2 == 0) {
                s1[i] = sequence[i] * 1;
                s2[i] = sequence[i] * -1;
            } else {
                s1[i] = sequence[i] * -1;
                s2[i] = sequence[i] * 1;
            }
        }
        
        long gm1 = s1[0];
        long cm1 = gm1;
        long gm2 = s2[0];
        long cm2 = gm2;
        
        for (int i = 1 ; i < l ; i++) {
            cm1 = Math.max(s1[i], cm1 + s1[i]);
            cm2 = Math.max(s2[i], cm2 + s2[i]);
            
            gm1 = Math.max(cm1, gm1);
            gm2 = Math.max(cm2, gm2);
        }
        
        return Math.max(gm1, gm2);
    }
}