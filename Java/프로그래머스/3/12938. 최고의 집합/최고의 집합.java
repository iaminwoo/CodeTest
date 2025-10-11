class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(s < n) return new int[]{-1};
        
        int i = 0;
        while(n > 0) {
            answer[i] = s / n;
            s -= answer[i];
            n--;
            i++;
        }
        
        return answer;
    }
}