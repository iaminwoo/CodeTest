class Solution {
    public String solution(int a, int b) {
        final int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;
        
        for(int i = 0 ; i < a - 1 ; i++) {
            totalDays += daysInMonth[i];
        }
        
        totalDays += b;
        
        final String[] day = {"THU","FRI","SAT", "SUN","MON","TUE","WED"};
        
        return day[totalDays % 7];
    }
}