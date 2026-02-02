import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] stringArr = new String[numbers.length];
        
        for (int i = 0 ; i < numbers.length ; i++) {
            stringArr[i] = "" + numbers[i];
        }
        
        Arrays.sort(stringArr, (a, b) -> (b + a).compareTo(a + b));
        
        if (stringArr[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (String s : stringArr) {
            sb.append(s);
        }
        return sb.toString();
    }
}