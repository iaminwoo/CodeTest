import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        // divisor로 나누어지는 값 오름차순 반환
        int length = 0;
        for(int num : arr) {
            if(num % divisor == 0) {
                length++;
            }
        }
        
        if(length == 0) {
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        int[] answer = new int[length];

        int index = 0;
        for(int num : arr) {
            if(num % divisor == 0) {
                answer[index++] = num;
            }
        }

        answer = Arrays.stream(answer).sorted().toArray();

        return answer;
    }
}