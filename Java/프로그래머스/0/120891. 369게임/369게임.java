class Solution {
    public int solution(int order) {
        int answer = 0;
        
        while (order > 0) {
            int checkNum = order % 10;
            
            if(checkNum != 0 && checkNum % 3 == 0){
                answer++;
            }
            order /= 10;
        }
        
        return answer;
    }
}