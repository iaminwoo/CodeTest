class Solution {
    public int solution(int balls, int share) {
        double answer = 1;
        
        while (share != 0){
            answer *= balls--;
            answer /= share--;
        }
        
        return (int)Math.round(answer);
    }
}