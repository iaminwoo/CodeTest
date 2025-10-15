import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int light = 0;
        int heavy = people.length - 1;
        
        while(true) {
            if(people[heavy] + people[light] <= limit) light++;
            answer++;
            heavy--;
            
            if(heavy <= light) {
                if(heavy == light) answer++;
                break;
            }
        }
        
        
        
        
        return answer;
    }
}