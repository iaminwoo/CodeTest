class Solution {
    public int solution(String t, String p) {
        int answer = 0;


        // p 보다 작은 t 의 부분 문자열
        for(int i = 0 ; i < t.length()-p.length()+1 ; i++) {
            if(Long.parseLong(p) >= Long.parseLong(t.substring(i, i+p.length()))){
                answer++;
            }
        }


        return answer;
    }
}