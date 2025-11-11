class Solution {
    private int isPrime(int sum) {
        for(int i = 2 ; i * i <= sum ; i++) {
            if(sum % i == 0) return 0;
        }
        return 1;
    }
    
    public int solution(int[] nums) {
        int answer = 0;

        for(int a = 0 ; a < nums.length ; a++) {
            for(int b = a + 1 ; b < nums.length ; b++) {
                for(int c = b + 1 ; c < nums.length ; c++) {
                    answer += isPrime(nums[a] + nums[b] + nums[c]);
                }
            }
        }

        return answer;
    }
}