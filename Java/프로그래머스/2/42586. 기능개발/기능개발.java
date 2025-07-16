import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(i);
        }

        int today = 0;
        int count = 0;
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int index = queue.poll();
            int reqDay = (int) Math.ceil((100.0 - progresses[index]) / speeds[index]);

            if (reqDay <= today) {
                count++;
            } else {
                if (count > 0) list.add(count);
                today = reqDay;
                count = 1;
            }
        }

        if (count > 0) list.add(count);

        return list.stream().mapToInt(i -> i).toArray();
    }
}