class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = arr;

        // 홀짝 인덱스 더하기
        int index = answer.length % 2 == 0 ? 1 : 0;
        for(int i = index ; i < answer.length ; i += 2) {
            answer[i] += n;
        }

        return answer;
    }
}