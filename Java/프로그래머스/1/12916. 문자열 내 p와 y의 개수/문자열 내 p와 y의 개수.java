class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // 문자열의 p와 y의 갯수 비교 (같거나 없으면 true, 다르면 false)
        int pNum = 0;
        int yNum = 0;
        
        for(int i = 0 ; i < s.length() ; i++) {
            int charCheck = s.charAt(i) - 'P';
            if(charCheck == 0 || charCheck == 32) {
                pNum++;
            } else if (charCheck == 9 || charCheck == 41) {
                yNum++;
            }
        }

        if(pNum != yNum) answer = false;

        return answer;
    }
}