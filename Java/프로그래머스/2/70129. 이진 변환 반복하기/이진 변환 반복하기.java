public class Solution {
    public int[] solution(String s) {
        int repeatCount = 0;
        int zeroCount = 0;
        while(!s.equals("1")) {
            repeatCount++;

            char[] arr = s.toCharArray();

            StringBuilder sb = new StringBuilder();
            for(char c : arr) {
                if(c == '0') {
                    zeroCount++;
                } else {
                    sb.append(c);
                }
            }

            int c = sb.length();
            s = Integer.toString(c, 2);
        }

        return new int[] {repeatCount, zeroCount};
    }
}