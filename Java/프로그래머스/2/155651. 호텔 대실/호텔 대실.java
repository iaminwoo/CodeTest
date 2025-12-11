import java.util.*;

class Solution {
    private int stringTimeToIntTime(String time) {
        String[] parts = time.split(":");
        String hour = parts[0];
        String min = parts[1];
        
        int result = Integer.parseInt(min);
        result += Integer.parseInt(hour) * 60;
        
        return result;
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[][] bookTime = new int[book_time.length][2];
        for (int i = 0 ; i < book_time.length ; i++) {
            String[] b = book_time[i];
            bookTime[i] = new int[]{stringTimeToIntTime(b[0]), stringTimeToIntTime(b[1])};
        }
        
        Arrays.sort(bookTime, (a, b) -> a[0] - b[0]);
        
        List<int[]> rooms = new ArrayList<>();
        for (int[] b : bookTime) {
            int bookStart = b[0];
            int bookEnd = b[1];
            
            boolean found = false;
            for (int[] r : rooms) {
                int end = r[1] + 10;
                
                if (end <= bookStart) {
                    r[0] = bookStart;
                    r[1] = bookEnd;
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                rooms.add(new int[]{bookStart, bookEnd});
            }
        }
        
        return rooms.size();
    }
}