class Solution {
    public int solution(int n) {
        int answer = 2;
        int squareRoot = 1;
        
        while(squareRoot * squareRoot <= n){
            if(squareRoot * squareRoot == n){
                return 1;
            } else {
                squareRoot++;
            }
        }
        
        return answer;
    }
}