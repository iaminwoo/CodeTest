class Solution {
    public String solution(String s, int n) {
        String answer = "";

        String[] parts = s.split("");
        StringBuilder sb = new StringBuilder();
        for(String part : parts) {
            if(!part.equals(" ")) {
                int check = part.charAt(0) + n;
                if(part.charAt(0) <= 90 && check > 90 || part.charAt(0) > 90 && check > 122) check -= 26;
                part = "" + (char) check;
            }
            sb.append(part);
        }
        answer = sb.toString();

        return answer;
    }
}