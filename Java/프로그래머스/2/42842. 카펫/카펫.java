class Solution {
    public int[] solution(int brown, int yellow) {
        for(int y = 1 ; (y * y) <= yellow ; y++) {
            if(yellow % y != 0) continue;
            int x = yellow / y;
            
            if(2 * x + 2 * y + 4 == brown) {
                return new int[] {x + 2, y + 2};
            }
        }
        return null;
    }
}