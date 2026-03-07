import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // 중복 제거
        Set<String> noRepeatReport = new HashSet<>();
        
        for (String r : report) {
            noRepeatReport.add(r);
        }
        
        // 신고 계산
        Map<String, Integer> reportPerUser = new HashMap<>();
        Map<String, List<String>> userPerReport = new HashMap<>();
        
        for (String r : noRepeatReport) {
            String[] parts = r.split(" ");
            String from = parts[0];
            String to = parts[1];
            
            reportPerUser.put(to, reportPerUser.getOrDefault(to, 0) + 1);
            userPerReport.computeIfAbsent(to, a -> new ArrayList<>()).add(from);
        }
        
        // 정지 인원 확인 및 메일 카운트
        Map<String, Integer> mailCount = new HashMap<>();
        
        for (String user : id_list) {
            if (reportPerUser.getOrDefault(user, 0) >= k) {
                List<String> reports = userPerReport.get(user);
                for (String u : reports) {
                    mailCount.put(u, mailCount.getOrDefault(u, 0) + 1);
                }
            }
        }
        
        // 결과
        int l = id_list.length;
        int[] answer = new int[l];
        
        for (int i = 0 ; i < l ; i++) {
            answer[i] = mailCount.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}