import java.util.*;

class Solution {
    private int dateToDay(String date) {
        String[] dateSplit = date.split("\\."); 
        return Integer.parseInt(dateSplit[0]) * (28 * 12) + Integer.parseInt(dateSplit[1]) * 28 + Integer.parseInt(dateSplit[2]);
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        
        for (String term : terms) {
            String[] parts = term.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]) * 28);
        }
        
        int[] expirationDays = new int[privacies.length];
        
        for (int i = 0 ; i < privacies.length ; i++) {
            String[] parts = privacies[i].split(" ");
            
            String date = parts[0];
            String type = parts[1];
            
            int startDay = dateToDay(date);
            
            expirationDays[i] = startDay + termMap.get(type);
        }
        
        List<Integer> expiredPrivacies = new ArrayList<>();
        
        for (int i = 0 ; i < expirationDays.length ; i++) {
            int day = expirationDays[i];
            if (day <= dateToDay(today)) expiredPrivacies.add(i + 1);
        }
        
        return expiredPrivacies.stream()
            .mapToInt(Integer::intValue).toArray();
    }
}