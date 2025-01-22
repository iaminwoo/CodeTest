import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;

        // 최대로 지원할 수 있는 부서 수
        Arrays.sort(d);
        System.out.println(Arrays.toString(d));

        int sum = 0;
        for(int num : d) {
            sum += num;
            if(sum > budget) {
                break;
            } else {
                answer++;
            }
        }

        return answer;
    }
}