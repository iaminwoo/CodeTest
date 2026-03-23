class Solution {
    private int timeToMin(String time) {
        int mid = time.length() > 3 ? 2 : 1;
        String hour = time.substring(0, mid);
        String min = time.substring(mid);
        
        return Integer.parseInt(hour) * 60 + Integer.parseInt(min);
    }
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0 ; i < schedules.length ; i++) {
            schedules[i] = timeToMin("" + schedules[i]);
        }
        
        for (int i = 0 ; i < timelogs.length ; i++) {
            int[] person = timelogs[i];
            int promiseTime = schedules[i];
            int count = 0;
            
            for (int j = 0 ; j < 7 ; j++) {
                int day = (j + startday - 1) % 7;
                if (day == 5 || day == 6) continue;
                
                if (timeToMin("" + person[j]) <= promiseTime + 10) count++;
            }
            
            if (count >= 5) answer++;
        }
        
        return answer;
    }
}