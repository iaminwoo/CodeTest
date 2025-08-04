class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        int m = arr2[0].length;
        
        int[][] answer = new int[n][m];
        
        for(int a = 0 ; a < n ; a++) {
            for(int b = 0 ; b < m ; b++) {
                int sum = 0;
                
                for(int c = 0 ; c < arr1[0].length ; c++) {
                    sum += arr1[a][c] * arr2[c][b];
                }
                
                answer[a][b] = sum;
            }
        }
        
        return answer;
    }
}