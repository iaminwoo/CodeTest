class Solution {
    public long solution(int n) {
        if(n == 1) return 1;
        
        int a = 1;
        int b = 2;
        
        for(int i = 0 ; i < n - 2 ; i++) {
            int temp = (a + b) % 1234567;
            a = b;
            b = temp;
        }
        
        return b;
    }
}