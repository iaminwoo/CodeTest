import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        double[] failRate = new double[N];
        
        // 스테이지별 실패한 사용자
        for (int stage : stages) {
            if (stage > N) continue;
            failRate[stage - 1] += 1;
        }
        
        
        // 스테이지별 실패율
        double userLeft = stages.length;
        for (int i = 0 ; i < N ; i++) {
            double nextUserLeft = userLeft - failRate[i];
            failRate[i] = failRate[i] / userLeft;
            userLeft = nextUserLeft;
            if (userLeft == 0) break;
        }
        
        
        // 스테이지별 실패율 기록
        Map<Double, List<Integer>> stageFailRate = new HashMap<>();
        
        for (int i = 0 ; i < N ; i++) {
            stageFailRate.computeIfAbsent(failRate[i], a -> new ArrayList<>()).add(i + 1);
        }
        
        
        // 실패율 정렬
        Arrays.sort(failRate);
        
        
        // 정답 계산
        int[] answer = new int[N];
        
        for (int i = N - 1 ; i >= 0 ;) {
            List<Integer> sameFailRateStages = stageFailRate.get(failRate[i]);
            
            for (int j = 0 ; j < sameFailRateStages.size() ; j++) {
                answer[N - 1 - i] = sameFailRateStages.get(j);
                i--;
            }
            
        }
        
        return answer;
    }
}