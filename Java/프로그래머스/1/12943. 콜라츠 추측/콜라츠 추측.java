class Solution {
    public int solution(int num) {
        int answer = 0;

        // 콜라츠 추측
        long longNum = num;
        int count = 0;
        while (longNum != 1) {
            count++;
            if(longNum % 2 == 0) {
                longNum /= 2;
            } else {
                longNum *= 3;
                longNum += 1;
            }
            if(count >= 500) {
                count = -1;
                break;
            }
        }
        answer = count;

        return answer;
    }
}