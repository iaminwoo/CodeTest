import java.util.*;

public class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        for(int n : course) {
            Map<String, Integer> countMap = new HashMap<>();
            int[] maxCount = new int[1];

            for(String order : orders) {
                addCourse(order, n, countMap, maxCount);
            }

            for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
                if(entry.getValue() == maxCount[0] && 2 <= maxCount[0]) {
                    result.add(entry.getKey());
                }
            }
        }

        Collections.sort(result);

        return result.toArray(new String[0]);
    }

    private void addCourse(String order, int n, Map<String, Integer> countMap, int[] maxCount) {
        char[] charOrder = order.toCharArray();
        Arrays.sort(charOrder);
        makeCourse(charOrder, countMap, n, "", -1, maxCount);
    }

    private void makeCourse(char[] charOrder, Map<String, Integer> countMap, int n, String menu, int j, int[] maxCount) {
        if(menu.length() == n) {
            int value = countMap.getOrDefault(menu, 0) + 1;
            countMap.put(menu, value);

            if(value > maxCount[0]) maxCount[0] = value;
        }

        for(int i = j+1 ; i < charOrder.length ; i++) {
            makeCourse(charOrder, countMap, n, menu + charOrder[i], i, maxCount);
        }
    }
}