class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        // 가장 가까운 같은 글자
        for(int i = 0 ; i < s.length() ; i++) {
            answer[i] = -1;
            for(int j = 0 ; j < i ; j++) {
                if(s.charAt(i) == s.charAt(j)) answer[i] = i - j;
            }
        }

        return answer;
    }
}