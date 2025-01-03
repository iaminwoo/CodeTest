class Solution {
    public String solution(String[] seoul) {
        String answer = "";

        int index = 0;
        for(int i = 0 ; i < seoul.length ; i++) {
            if(seoul[i].equals("Kim")) {
                index = i;
            }
        }
        answer = String.format("김서방은 %s에 있다", index);

        return answer;
    }
}