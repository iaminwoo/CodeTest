import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length - 5];

        Arrays.sort(num_list);
        int index = 0;
        for(int i = 5 ; i < num_list.length ; i++) {
            answer[index++] = num_list[i];
        }

        return answer;
    }
}