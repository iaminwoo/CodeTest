class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0 ; i < n ; i++) {
            int result = arr1[i] | arr2[i];
            
            final StringBuilder sb = new StringBuilder();
            while(result > 0) {
                if(result % 2 == 1) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
                
                result = result >> 1;
            }
            
            for(int j = sb.length() ; j < n ; j++) {
                sb.append(" ");
            }
            sb.reverse();
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}