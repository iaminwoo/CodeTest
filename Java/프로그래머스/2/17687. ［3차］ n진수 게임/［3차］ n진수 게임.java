class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder result = new StringBuilder();
        
        int i = 0;
        while (result.length() < t * m) {
            result.append(Integer.toString(i, n).toUpperCase());
            i++;
        }
        
        StringBuilder answer = new StringBuilder();
        
        for (int turn = 0; turn < t; turn++) {
            answer.append(result.charAt((p - 1) + (m * turn)));
        }
        
        return answer.toString();
    }
}