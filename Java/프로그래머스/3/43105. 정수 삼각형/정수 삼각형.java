class Solution {
    public int solution(int[][] triangle) {
        int answer = triangle[0][0];
        
        int[] prev = new int[1];
        prev[0] = answer;
        
        for(int i = 1 ; i < triangle.length ; i++) {
            int[] curr = new int[triangle[i].length];
            
            for(int j = 0 ; j <= i ; j++) {
                
                
                int left = (j == 0) ? 0 : prev[j-1];
                int right = (j >= prev.length) ? 0 : prev[j];
                
                curr[j] = triangle[i][j] + Math.max(left, right);
                if(answer < curr[j]) answer = curr[j];
                
                
            }
            prev = curr;
        }
        
        return answer;
    }
}