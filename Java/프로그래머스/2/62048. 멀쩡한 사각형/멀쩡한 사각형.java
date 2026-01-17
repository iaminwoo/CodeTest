class Solution {
    private long GCD(long a, long b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
    
    public long solution(long w, long h) {
        return w * h - (w / GCD(w, h) + h / GCD(w, h) - 1) * GCD(w, h);
    }
}