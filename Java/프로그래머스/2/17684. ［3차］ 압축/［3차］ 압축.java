import java.util.*;

class Solution {
    private Map<String, Integer> dict = new HashMap<>();
    private int dictSize = 27;
    
    private int[] checkDict(String msg, int idx) {
        if(msg.length() <= idx) return new int[]{0};
        String target = msg.substring(0, idx + 1);
        
        if(target.length() == 1 || dict.keySet().contains(target)) {
            
            int[] result = checkDict(msg, idx + 1);
            if(result[0] == 0) {
                if(target.length() == 1) return new int[]{1, target.charAt(0) - 64};
                
                return new int[]{target.length(), dict.get(target)};
            }
            
            return result;
        } else {
            dict.put(target, dictSize++);
            return new int[]{0};
        }
    }
    
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();;
        
        int loop = 0;
        while(msg.length() > 0) {
            int[] result = checkDict(msg, 0);
            
            answer.add(result[1]);
            
            msg = msg.substring(result[0], msg.length());
            
            if(loop > 5) break;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}