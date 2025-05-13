public class Solution {
    public int solution(String input) {
        // 1. 스트링 자르기
        int result = Integer.MAX_VALUE;
        for (int i = 1 ; i <= input.length() ; i++) {
            String[] sArr = new String[input.length()/i + (input.length()%i > 0 ? 1 : 0)];

            for (int j = 0 ; j < sArr.length ; j++) {
                sArr[j] = input.substring(i * j, Math.min(input.length(), i * (j + 1)));
            }

            // 2. 계산
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int index = 0 ; index < sArr.length ; index++) {
                if(index != sArr.length-1 && sArr[index].equals(sArr[index+1])) {
                    count++;
                } else {
                    if(count > 1) sb.append(count);
                    sb.append(sArr[index]);
                    count = 1;
                }
            }
            String compact = sb.toString();

            // 3. 결과 비교
            result = Math.min(result, compact.length());
        }

        return result;
    }
}