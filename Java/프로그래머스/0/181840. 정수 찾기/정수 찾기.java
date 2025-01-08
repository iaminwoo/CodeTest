class Solution {
    public int solution(int[] num_list, int n) {
        int answer = 0;

        // num_list 안에 n이 있는지
        for(int num : num_list) {
            if(num == n) {
                answer = 1;
            }
        }

        return answer;
    }
}