import java.util.*;

public class Solution {
    public int[] solution(String[] info, String[] query) {
        List<Integer> result = new ArrayList<>();

        Map<String, List<Integer>> scoreMap = new HashMap<>();
        makeMap(info, scoreMap);
        for(String search : query) {
            String key = search.replaceAll("[ 0-9]","").replaceAll("and","");
            String scoreLimit = search.replaceAll("[^0-9]","");
            result.add(count(scoreLimit, scoreMap.get(key)));
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int count(String scoreLimit, List<Integer> scores) {
        if (scores == null || scores.isEmpty()) return 0;
        return scores.size() - binarySearch(Integer.parseInt(scoreLimit), scores);
    }

    private int binarySearch(int scoreLimit, List<Integer> scores) {
        int start = 0;
        int end = scores.size() - 1;

        while(start < end) {
            int mid = (start + end) / 2;

            if(scores.get(mid) >= scoreLimit) {
                // down
                end = mid;
            } else {
                // up
                start = mid + 1;
            }
        }

        if(scores.get(start) < scoreLimit) {
            return scores.size();
        }
        return start;
    }

    private void makeMap(String[] info, Map<String, List<Integer>> scoreMap) {
        for(String person : info) {
            String[] arr = person.split(" ");
            addMap(arr, scoreMap, "", 0);
        }

        for(List<Integer> scores : scoreMap.values()) {
            Collections.sort(scores);
        }
    }

    private void addMap(String[] arr, Map<String, List<Integer>> scoreMap, String key, int i) {
        if(i == 4) {
            scoreMap.putIfAbsent(key, new ArrayList<>());
            scoreMap.get(key).add(Integer.valueOf(arr[i]));
            return;
        }

        addMap(arr, scoreMap, key + arr[i], i + 1);
        addMap(arr, scoreMap, key + "-", i + 1);
    }
}