class Solution {
    public String solution(String s) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        char[] ca = s.toCharArray();
        boolean firstLetter = true;
        
        for(int i = 0 ; i < ca.length ; i++) {
            if(firstLetter && ca[i] != ' ') {
                sb.append(Character.toUpperCase(ca[i]));
                firstLetter = false;
            } else {
                if(ca[i] == ' ') firstLetter = true;
                sb.append(Character.toLowerCase(ca[i]));
            }
            
        }
        
        answer = sb.toString();
        return answer;
    }
}