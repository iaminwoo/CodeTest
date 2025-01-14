class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int[] answer = {};


        // 배열의 원소 삭제하기
        int index = 0;
        for(int num : arr) {
            boolean isPresent = false;

            for(int numDel : delete_list) {
                if (num == numDel) {
                    isPresent = true;
                    break;
                }
            }

            if(!isPresent) index++;
        }

        int[] toAnswer = new int[index];

        index = 0;
        for(int num : arr) {
            boolean isPresent = false;

            for(int numDel : delete_list) {
                if (num == numDel) {
                    isPresent = true;
                    break;
                }
            }

            if(!isPresent) toAnswer[index++] = num;
        }

        answer = toAnswer;


        return answer;
    }
}