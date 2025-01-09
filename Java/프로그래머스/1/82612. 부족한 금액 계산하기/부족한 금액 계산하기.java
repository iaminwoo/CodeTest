class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;

        // 놀이기구를 count 번 타면 가격
        long sum = (long) count * (count + 1) / 2 * price;
        // 부족한 금액
        answer = sum < money ? 0 : sum - money;

        return answer;
    }
}