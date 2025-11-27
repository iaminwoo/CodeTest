class Solution {
    private String numToKStr(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }
    
    private int isPrime(long p) {
        if(p == 1) return 0;
        
        for(long i = 2 ; i * i <= p ; i++) {
            if(p % i == 0) {
                return 0;
            }
        }
        
        return 1;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        
        String str = numToKStr(n, k);
        String[] nums = str.split("0");
        
        for(String s : nums) {
            if(!s.isBlank()) answer += isPrime(Long.parseLong(s));
        }
        
        return answer;
    }
}