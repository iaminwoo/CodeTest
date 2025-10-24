class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int n = 1 ; n <= number ; n++) {
            int p = 0;
            for(int i = 1 ; i * i <= n ; i++) {
                if(n % i == 0) {
                    p += 2;
                    if(n / i == i) p--;
                }
            }
            
            if(p > limit) p = power;
            
            answer += p;
        }
        
        return answer;
    }
}