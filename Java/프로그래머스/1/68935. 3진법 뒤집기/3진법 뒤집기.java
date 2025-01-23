import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        int answer = 0;

        // 3진법 뒤집기
        ArrayList<Integer> trinary = new ArrayList<>();
        while (n > 0) {
            trinary.add(n % 3);
            n = n / 3;
        }
        for(int i = 0 ; i < trinary.size() ; i++){
            answer += trinary.get(i) * (int) Math.pow(3, trinary.size() - i - 1);
        }

        return answer;
    }
}