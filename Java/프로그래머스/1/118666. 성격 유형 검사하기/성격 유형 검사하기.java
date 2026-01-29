import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        Map<String, Integer> types = new HashMap<>();
        types.put("R", 0);
        types.put("T", 0);
        types.put("C", 0);
        types.put("F", 0);
        types.put("J", 0);
        types.put("M", 0);
        types.put("A", 0);
        types.put("N", 0);
        
        for (int i = 0 ; i < survey.length ; i++) {
            String[] type = survey[i].split("");
            int choice = choices[i] - 4;
            
            if (choice > 0) {
                // type[1]
                types.put(type[1], types.get(type[1]) + choice);
            } else {
                // type[0]
                types.put(type[0], types.get(type[0]) - choice);
            }
        }
        
        String answer = "";
        if (types.get("R") >= types.get("T")) answer += "R";
        else answer += "T";
        
        if (types.get("C") >= types.get("F")) answer += "C";
        else answer += "F";
        
        if (types.get("J") >= types.get("M")) answer += "J";
        else answer += "M";
        
        if (types.get("A") >= types.get("N")) answer += "A";
        else answer += "N";
        
        return answer;
    }
}