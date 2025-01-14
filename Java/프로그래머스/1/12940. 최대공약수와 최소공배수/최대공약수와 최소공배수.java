class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {};


        // n, m 의 최소 공배수, 최대 공약수
        int GCD = getGCD(n, m);
        int LCM = (n * m) / GCD;
        answer = new int[]{GCD, LCM};


        return answer;
    }

    private int getGCD(int n, int m) {
        while(m != 0) {
            int temp = m;
            m = n % m;
            n = temp;
        }
        return n;
    }
}