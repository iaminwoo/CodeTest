import java.util.*;

class Solution {
    List<List<Integer>> infos = new ArrayList<>();
    
    private void addInfos(String[] info) {
        for (String i : info) {
            String[] parts = i.split(" ");
            
            int index = getIndex(parts).get(0);
            
            int score = Integer.parseInt(parts[4]);
            infos.get(index).add(score);
        }
    }
    
    private List<Integer> getIndex(String[] parts) {
        List<Integer> indexs = new ArrayList<>();
        indexs.add(0); // 시작 인덱스 0

        // 1. Language
        int[] langVals = parts[0].equals("cpp") ? new int[]{0} :
                         parts[0].equals("java") ? new int[]{1} :
                         parts[0].equals("python") ? new int[]{2} : new int[]{0, 1, 2}; // "-"인 경우
        indexs = calculate(indexs, langVals, 8);

        // 2. Position
        int[] posVals = parts[1].equals("backend") ? new int[]{0} :
                        parts[1].equals("frontend") ? new int[]{1} : new int[]{0, 1};
        indexs = calculate(indexs, posVals, 4);

        // 3. Experience
        int[] expVals = parts[2].equals("junior") ? new int[]{0} :
                        parts[2].equals("senior") ? new int[]{1} : new int[]{0, 1};
        indexs = calculate(indexs, expVals, 2);

        // 4. Food
        int[] foodVals = parts[3].equals("chicken") ? new int[]{0} :
                         parts[3].equals("pizza") ? new int[]{1} : new int[]{0, 1};
        indexs = calculate(indexs, foodVals, 1);

        return indexs;
    }

    // 중복 코드를 줄이기 위한 헬퍼 메서드
    private List<Integer> calculate(List<Integer> current, int[] choices, int weight) {
        List<Integer> next = new ArrayList<>();
        for (int idx : current) {
            for (int choice : choices) {
                next.add(idx + (choice * weight));
            }
        }
        return next;
    }
    
    public int[] solution(String[] info, String[] query) {
        // 초기화 (0~25번 인덱스)
        for (int i = 0; i <= 25; i++) {
            infos.add(new ArrayList<>());
        }
        addInfos(info);

        // [핵심 1] 쿼리 시작 전, 모든 점수 리스트를 딱 한 번 정렬합니다.
        for (List<Integer> list : infos) {
            Collections.sort(list);
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String q = query[i].replace("and ", "");
            String[] parts = q.split(" ");
            
            List<Integer> indexs = getIndex(parts);
            int targetScore = Integer.parseInt(parts[4]);
            int totalCount = 0;

            // [핵심 2] 여러 인덱스의 리스트에서 각각 이진 탐색을 수행합니다.
            for (int index : indexs) {
                List<Integer> scores = infos.get(index);
                totalCount += scores.size() - binarySearch(scores, targetScore);
            }
            answer[i] = totalCount;
        }

        return answer;
    }

    // [핵심 3] Lower Bound 이진 탐색 구현
    private int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left; // target 이상의 점수가 처음 나타나는 위치(인덱스)
    }
}