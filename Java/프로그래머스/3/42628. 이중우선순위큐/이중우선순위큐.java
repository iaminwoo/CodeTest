import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a,b) -> b - a);
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        List<Integer> remains = new ArrayList<>();
        
        for(String op : operations) {
            if(remains.isEmpty()) {
                maxQueue = new PriorityQueue<>((a,b) -> b - a);
                minQueue = new PriorityQueue<>();
            }
            
            String[] ops = op.split(" ");
            
            if(ops[0].equals("I")) {
                int num = Integer.parseInt(ops[1]);
                
                maxQueue.add(num);
                minQueue.add(num);
                remains.add(num);
            } else{
                if(remains.isEmpty()) continue;
                
                if(op.equals("D 1")) {
                    int num = maxQueue.poll();
                    remains.remove((Integer) num);
                } else {
                    int num = minQueue.poll();
                    remains.remove((Integer)num);
                }
            }
        }
        
        if(remains.isEmpty()) {
            answer = new int[]{0, 0};
        } else {
            while(true){
                if(remains.contains(maxQueue.peek())) {
                    answer[0] = maxQueue.poll();
                    break;
                }
                maxQueue.poll();
            }
            while(true){
                if(remains.contains(minQueue.peek())) {
                    answer[1] = minQueue.poll();
                    break;
                }
                minQueue.poll();
            }
        }
        
        
        return answer;
    }
}