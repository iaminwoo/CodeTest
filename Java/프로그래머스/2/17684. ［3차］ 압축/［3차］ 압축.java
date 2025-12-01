import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        
        // A ~ Z 추가 (1단계)
        for(int i = 1 ; i <= 26 ; i++) {
            dict.put("" + (char)(i + 64), i);
        }
        
        int idx = 0;
        while(idx < msg.length()) {
            // 입력과 일치하는 가장 긴 문자열 w 찾기 (2단계)
            String w = "";
            
            // 입력위치부터 한글자씩 늘려가며 사전 확인
            for(int len = 0 ; idx + len < msg.length() ; len++) {
                String wc = msg.substring(idx, idx + len + 1);
                
                if(dict.containsKey(wc)) {
                    // 사전에 있으면 w 에 저장
                    w = wc;
                } else {
                    // 사전에 없으면 사전 추가 후 반복문 종료 (4단계)
                    dict.put(wc, dict.size() + 1);
                    break;
                }
            }
            
            // w의 인덱스 반환 및 인덱스 이동 (3단계)
            answer.add(dict.get(w));
            idx += w.length();
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}