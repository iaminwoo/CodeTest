class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        // 명함을 담는 가장 작은 지갑
        int heights = 0;
        int width = 0; // 가로가 더 크게
        for(int[] card : sizes) {
            width = Math.max(width, Math.max(card[0], card[1]));
            heights = Math.max(heights, Math.min(card[0], card[1]));
        }
        answer = heights * width;

        return answer;
    }
}