class Solution {
    
    private boolean isPrime(int num) {
        if (num == 1) return false;
        if (num == 2) return true;
        
        for (int i = 2 ; i * i <= num ; i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
    
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1 ; i <= n ; i++) {
            if (isPrime(i)) answer++;
        }
        
        return answer;
    }
}