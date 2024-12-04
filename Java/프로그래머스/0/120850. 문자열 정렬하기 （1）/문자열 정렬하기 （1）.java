import java.util.ArrayList;

class Solution {
    public int[] solution(String my_string) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < my_string.length() ; i++){
            int charToNum = my_string.charAt(i) - 48;
            if(charToNum >= 0 && charToNum < 10){
                list.add(charToNum);
            }
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).sorted().toArray();

        return answer;
    }
}