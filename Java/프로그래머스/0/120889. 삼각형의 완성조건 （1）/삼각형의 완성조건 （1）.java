class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int biggestSide = 0;
        int total = 0;
        
        for(int side : sides) {
            if(side > biggestSide) biggestSide = side;
            total += side;
        }
        
        total -= biggestSide;
        
        if(total > biggestSide) {
            answer = 1;
        } else {
            answer = 2;
        }
        
        return answer;
    }
}