import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] sArr = s.substring(2, s.length() - 2).split("\\},\\{");
        Map<Integer, String[]> map = new HashMap<>();
        
        for(String string : sArr){
            String[] sArr2 = string.split(",");
            map.put(sArr2.length, sArr2);
        }
        
        int[] answer = new int[map.size()];
        
        Set<Integer> set = new HashSet<>();
        for(int i = 1 ; i <= map.size() ; i++){
            String[] nums = map.get(i);
            
            for(String n : nums){
                int num = Integer.parseInt(n);
                if(!set.contains(num)){
                    set.add(num);
                    answer[i-1] = num;
                }
            }
        }
        
        return answer;
    }
}