class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int n = storey % 10;
            int next_n = (storey / 10) % 10;
            
            if (n > 5 || (n == 5 && next_n >= 5)) {
                answer += 10 - n;
                storey = (storey / 10) + 1;
            } else {
                answer += n;
                storey = storey / 10;
            }
        }
        
        return answer;
    }
}