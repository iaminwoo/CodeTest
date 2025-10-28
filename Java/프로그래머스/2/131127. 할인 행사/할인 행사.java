import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int totalWant = 0;
        for(int num : number) {
            totalWant += num;
        }
        
        for(int i = 0 ; i < discount.length - totalWant + 1 ; i++) {
            Map<String, Integer> map = new HashMap<>();
        for(int j = i ; j < i + totalWant ; j++) {
            String product = discount[j];
            map.put(product, map.getOrDefault(product, 0) + 1);
        }
        
        boolean containAll = true;
        for(int itemIdx = 0 ; itemIdx < want.length ; itemIdx++) {
            if(map.getOrDefault(want[itemIdx], 0) != number[itemIdx]) {
                containAll = false;
                break;
            }
        }
        
        if(containAll) answer++;
        }
        
        return answer;
    }
}