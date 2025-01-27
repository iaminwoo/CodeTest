import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};

        // 두개 뽑아서 더하기
        ArrayList<Integer> numList = new ArrayList<>();
        for(int i = 0 ; i < numbers.length ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(!numList.contains(numbers[i] + numbers[j])) numList.add(numbers[i] + numbers[j]);
            }
        }
        answer = new int[numList.size()];
        int index = 0;
        for(int num : numList) {
            answer[index++] = num;
        }
        Arrays.sort(answer);

        return answer;
    }
}