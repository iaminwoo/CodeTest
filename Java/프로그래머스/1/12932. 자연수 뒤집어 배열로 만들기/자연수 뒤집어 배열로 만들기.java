class Solution {
    public int[] solution(long n) {
        int length = 0;
        long check = n;
        while(check > 0) {
            check /= 10;
            length++;
        }
        
        int[] answer = new int[length];
        
        for(int i = 0 ; i < length ; i++) {
            answer[i] = (int) (n % 10);
            n /= 10;
        }
        
        return answer;
    }
}