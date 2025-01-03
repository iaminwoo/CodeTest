class Solution {
    public boolean solution(int x) {
        boolean answer = true;

        // x의 자리수의 합으로 x가 나누어지는 하샤드 수 boolean
        int sum = 0;
        int num = x;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        if(x % sum != 0) answer = false;

        return answer;
    }
}