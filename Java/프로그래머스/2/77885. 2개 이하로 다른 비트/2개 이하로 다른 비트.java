class Solution {
    public long[] solution(long[] numbers) {
        int l = numbers.length;
        long[] answer = new long[l];
        
        for (int i = 0 ; i < l ; i++) {
            long n = numbers[i];
            String s = Long.toString(n, 2);
            
            s = "0" + s + "1";
            
            int idx = 0;
            for (int j = 0 ; j < s.length() ; j++) {
                if (s.charAt(j) == '0') idx = j;
            }
            
            String result = s.substring(0, idx) + '1' + '0' + s.substring(idx + 2, s.length());
            result = result.substring(0, result.length() - 1);
            
            answer[i] = Long.valueOf(result, 2);
        }
        
        return answer;
    }
}