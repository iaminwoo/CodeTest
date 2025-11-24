import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        final int l = topping.length;
        
        final int[] left = new int[l];
        final int[] right = new int[l];
        
        final Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < l ; i++){
            set.add(topping[i]);
            left[i] = set.size();
        }
        
        set.clear();
        
        for(int i = l - 1 ; i > 0 ; i--){
            set.add(topping[i]);
            right[i] = set.size();
        }
        
        for(int i = 0 ; i < l - 1 ; i++){
            if(left[i] == right[i + 1]) answer++;
        }
        
        return answer;
    }
}