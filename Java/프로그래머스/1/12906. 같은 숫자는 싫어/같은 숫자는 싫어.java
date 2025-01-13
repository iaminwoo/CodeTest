import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        // 배열 반복 제거
        List<Integer> arrList = new ArrayList<>();
        
        arrList.add(arr[0]);
        for(int i = 1 ; i < arr.length ; i++) {
            if(arrList.get(arrList.size()-1) != arr[i]) arrList.add(arr[i]);
        }
        
        int[] forAnswer = new int[arrList.size()];
        for(int i = 0 ; i < arrList.size() ; i++) {
            forAnswer[i] = arrList.get(i);
        }
        answer = forAnswer;

        return answer;
    }
}