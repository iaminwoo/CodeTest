class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        
        int[] count = new int[26];
        
        for(char c : before.toCharArray()) {
            count[c - 'a']++;
        }
        
        for(char c : after.toCharArray()) {
            count[c - 'a']--;
        }
        
        for(int i : count) {
            if(i != 0) return 0;
        }
        
        return 1;
    }
}