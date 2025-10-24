class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        
        while(true) {
            answer++;
            int aTeam = (a - 1) / (int) Math.pow(2, answer);
            int bTeam = (b - 1) / (int) Math.pow(2, answer);
            
            if(aTeam == bTeam) break;
        }

        return answer;
    }
}