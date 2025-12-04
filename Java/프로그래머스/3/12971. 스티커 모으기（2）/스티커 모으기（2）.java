class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        int l = sticker.length;
        
        if(l == 1) return sticker[0];
        if(l == 2) return Math.max(sticker[0], sticker[1]);
        
        // case 1 : 0 o
        int[] dp1 = new int[l - 1];
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for(int i = 2 ; i < l - 1 ; i++) {
            dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);
        }
        
        // case 2 : 0 x
        int[] dp2 = new int[l];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i = 2 ; i < l ; i++) {
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
        }
        
        // 두 케이스의 최대 값
        answer = Math.max(dp1[l - 2], dp2[l - 1]);

        return answer;
    }
}