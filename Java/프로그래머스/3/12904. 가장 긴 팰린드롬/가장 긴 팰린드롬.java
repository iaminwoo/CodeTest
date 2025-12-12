class Solution {
    public int solution(String s) {
        int answer = 0;
        
        if (s.length() == 1) return 1;
        
        char[] arr = s.toCharArray();
        
        for (int i = 0 ; i < arr.length - 1 ; i++) {
            int count = 1;
            
            int right = i + 1;
                while (right <= arr.length - 1 && arr[i] == arr[right]) {
                    count++;
                    right++;
                }
            
            if (i > 0) {
                int left = i - 1;
                
                while (left >= 0 && right <= arr.length - 1 && arr[left] == arr[right]) {
                    count += 2;
                    left--;
                    right++;
                }
            }
            
            answer = Math.max(answer, count);
        }

        return answer;
    }
}