import java.util.*;

class Solution {
    private int count;
    private int[][] qs;
    private int[] anss;
    
    private void makeInput(int index, int n, int[] input) {
        if (index == 5) {
            for (int i = 0 ; i < qs.length ; i++) {
                if (anss[i] != match(qs[i], input)) return;
            }
            count++;
            return;
        }
        
        int before = index == 0 ? 1 : input[index - 1] + 1;
        for (int i = before ; i <= n ; i++) {            
            input[index] = i;
            makeInput(index + 1, n, input);
        }
    }
    
    private int match(int[] a, int[] b) {
        int match = 0;
        
        for (int i : a) {
            for (int j : b) {
                if (i == j) match++;
            }
        }
        return match;
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        qs = q;
        anss = ans;
        
        int[] input = new int[5];
        makeInput(0, n, input);
        return count;
    }
}