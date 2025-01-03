class Solution {
    public long solution(long n) {
        long answer = 0;

        // n의 제곱근 x 찾기, x+1의 제곱 리턴
        int x = (int) Math.sqrt(n);
        answer = Math.pow(x,2)==n ? (long) Math.pow(x+1, 2) : -1;

        return answer;
    }
}