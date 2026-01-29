class Solution {
    
    private int timeToSecond(String time) {
        String[] parts = time.split(":");
        
        int second = 0;
        for (int i = 0 ; i <= 2; i++) {
            second += (Integer.parseInt(parts[i]) * (int)Math.pow(60, 2 - i));
        }
        return second;
    }
    
    private String secondToTime(long second) {
        String time = "";
        
        for (int i = 2 ; i >= 0 ; i--) {
            if (i < 2) time += ":";
            int timeSecond = (int)Math.pow(60, i);
            if (second / timeSecond < 10) time += "0";
            time += second / timeSecond;
            second = second % timeSecond;
        }
        return time;
    }
    
    
    public String solution(String play_time, String adv_time, String[] logs) {
        
        int video_length = timeToSecond(play_time);
        int[] video = new int[video_length + 1];
        
        for (String log : logs) {
            String[] parts = log.split("-");
            String start = parts[0];
            String end = parts[1];
            
            video[timeToSecond(start)]++;
            video[timeToSecond(end)]--;
        }
        
        int viewer = 0;
        for (int i = 0 ; i < video.length ; i++) {
            viewer = viewer + video[i];
            video[i] = viewer;
        }
        
        int adv_length = timeToSecond(adv_time);
        
        long totalView = 0;
        for (int i = 0 ; i < adv_length ; i++) {
            totalView += video[i];
        }
        
        long maxTotalView = totalView;
        int startSecond = 0;
        
        for (int adv_start = 0 ; adv_start < video_length - adv_length ; adv_start++) {
            totalView -= video[adv_start];
            totalView += video[adv_start + adv_length];
            if (totalView > maxTotalView) {
                startSecond = adv_start + 1;
                maxTotalView = totalView;
            }
        }
        
        return secondToTime(startSecond);
    }
}