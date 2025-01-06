class Solution {
    public int[] solution(int[] arr) {
        int answerLength = arr.length-1;
        if(answerLength == 0) return new int[]{-1};

        int[] answer = new int[answerLength];

        // arr에서 가장 작은 수 제거한 배열 리턴
        int smallestNum = arr[0];
        for(int num : arr) {
            if(num < smallestNum) {
                smallestNum = num;
            }
        }
        int index = 0;
        for(int num : arr) {
            if(num != smallestNum) {
                answer[index++] = num;
            }
        }

        return answer;
    }
}