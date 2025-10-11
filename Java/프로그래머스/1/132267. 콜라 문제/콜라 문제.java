class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(true) {
            answer += (n / a) * b;
            n = (n / a) * b + (n % a);
            if(n < a) break;
        }
        
        return answer;
    }
}