class Solution {
    public long solution(long n) {
        long answer = 0;

        int[] intArray = String.valueOf(n).chars().map(c -> c - '0')
                .map(i -> -i).sorted().map(i -> -i).toArray();

        for(int i : intArray) {
            answer = answer * 10 + i;
        }

        return answer;
    }
}