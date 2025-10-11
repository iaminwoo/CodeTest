class Solution {
    public int solution(int n) {
        int answer = 1;
        int tri = 1;
        int i = 2;
        
        while(true) {
            if(i + tri > n) break;
            
            if((n - tri) % i == 0) answer++;

            tri += i;
            i++;
        }
        
        return answer;
    }
}