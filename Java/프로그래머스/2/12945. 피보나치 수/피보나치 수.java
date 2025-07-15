import java.util.*;

class Solution {
    private static int[] mem = new int[1000001];
    
    private int fibonacciMod(int n) {
        if(mem[n] != -1) return mem[n];
        
        if(n == 0 || n == 1) {
            return mem[n] = n;
        }
        
        return mem[n] = (fibonacciMod(n-1) + fibonacciMod(n-2)) % 1234567;
    }
    
    public int solution(int n) {
        Arrays.fill(mem, -1);
        
        for(int i = 0 ; i <= n ; i++) {
            fibonacciMod(i);
        }
        
        return fibonacciMod(n);
    }
}