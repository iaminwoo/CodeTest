import java.util.*;

class Solution {
    private int getMinute(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
    private String getTime(int minute) {
        int hour = minute / 60;
        minute = minute - (hour * 60);
        
        StringBuilder sb = new StringBuilder();
        if (hour < 10) sb.append("0");
        sb.append(hour).append(":");
        if (minute < 10) sb.append("0");
        sb.append(minute);
        
        return sb.toString();
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String time : timetable) {
            pq.offer(getMinute(time));
        }
        
        int last = 0;
        boolean seat = false;
        
        int now = 540;
        int in = 0;
        for (int i = 0 ; i < n ; i++) {
            in = 0;
            while (in < m && !pq.isEmpty() && pq.peek() <= now) {
                last = pq.poll();
                in++;
            }
            
            now += t;
        }
        
        if (in < m) {
            return getTime(now - t);
        } else {
            return getTime(last - 1);
        }
    }
}