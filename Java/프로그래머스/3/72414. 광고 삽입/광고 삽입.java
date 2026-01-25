import java.util.*;

class Solution {
    private int[] videoTime;
    private int playTimeSecond;
    private int advTime;
    
    private void logALog(String log) {
        String[] parts = log.split("-");
        int start = timeToSecond(parts[0]);
        int end = timeToSecond(parts[1]);
        
        videoTime[start]++;
        videoTime[end]--;
    }
    
    private int timeToSecond(String time) {
        String[] parts = time.split(":");
        int second = 0;
        for (int i = 0 ; i < 3 ; i++) {
            second += Integer.parseInt(parts[i]) * Math.pow(60, 2 - i);
        }
        return second;
    }
    
    private void checkViewers() {
        int curr = 0;
        
        for (int i = 0 ; i < videoTime.length ; i++) {
            curr += videoTime[i];
            videoTime[i] = curr;
        }
    }
    
    private String secondToTime(int second) {
        String time = "";
        for (int i = 2 ; i >= 0 ; i--) {
            int pow = (int) Math.pow(60, i);
            String s = second / pow >= 10 ? "" + second / pow : "0" + second / pow;
            time += s;
            if (i > 0) time += ":";
            second = second % pow;
        }
        return time;
    }
    
    private String getMaxStart() {
        long maxWatchTime = 0;
        int maxStart = 0;
        
        long watchTime = 0;
        for (int i = 0 ; i < advTime ; i++) {
            watchTime += (long)videoTime[i];
        }
        
        int start = 0;
        int end = advTime - 1;
        
        if (maxWatchTime < watchTime) {
            maxWatchTime = watchTime;
            maxStart = start;
        }
        
        while (end < playTimeSecond) {
            watchTime -= (long)videoTime[start++];
            watchTime += (long)videoTime[++end];
            if (maxWatchTime < watchTime) {
                maxWatchTime = watchTime;
                maxStart = start;
            }
        }
        
        return secondToTime(maxStart);
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        playTimeSecond = timeToSecond(play_time);
        advTime = timeToSecond(adv_time);
        videoTime = new int[playTimeSecond + 1];
        
        for (String log : logs) {
            logALog(log);
        }
        
        checkViewers();
        
        return getMaxStart();
    }
}