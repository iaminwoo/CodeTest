import java.util.*;

class Solution {
    private boolean makeTripPlan(Map<String, List<String>> map, String airport, int tickets, List<String> result) {
        result.add(airport);
        
        if (tickets == 0) {
            // 모든 티켓을 다 사용함. 반복 종료.
            return true;
        } else {
            // 티켓이 남음. 다음 공항으로 이동해야 함.
            List<String> to = map.getOrDefault(airport, new ArrayList<>());
            
            // 근데 다른 공항으로 이동할 수 없음. 해당 공항 제거하고 이전으로 돌아감.
            if(to.size() == 0) {
                result.remove(result.size() - 1);
                return false;
            }
            
            // 알파벳순 정렬
            to.sort(null);
            
            int o = result.size();
            int toSize = to.size();
            
            for (int i = 0 ; i < toSize ; i++) {
                String newAirport = to.remove(i);
                boolean pass = makeTripPlan(map, newAirport, tickets - 1, result);
                if(pass) {
                    return true;
                } else {
                    to.add(i, newAirport);
                }
            }
            
            result.remove(result.size() - 1);
            return false;
        }
    }
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String[] t : tickets) {
            String from = t[0];
            String to = t[1];
            
            map.computeIfAbsent(from, f -> new ArrayList<>()).add(to);
        }
        
        List<String> result = new ArrayList<>();
        makeTripPlan(map, "ICN", tickets.length, result);
        
        return result.stream().toArray(String[]::new);
    }
}