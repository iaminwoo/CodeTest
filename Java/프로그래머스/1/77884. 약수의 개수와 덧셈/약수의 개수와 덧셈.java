class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        // left 부터 right 까지 약수의 개수 짝수인 수는 더하고, 약수의 개수 홀수인 수는 빼기
        while(left <= right) {
            int count = 0;
            for(int i = 1 ; i * i <= left ; i++) {
                if(left % i == 0) {
                    count++;
                    if(i != left / i) {
                        count++;
                    }
                }
            }
            if(count % 2 == 0) {
                answer += left;
            } else {
                answer -= left;
            }
            left++;
        }

        return answer;
    }
}