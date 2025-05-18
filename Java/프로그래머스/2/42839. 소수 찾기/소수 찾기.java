import java.util.*;

public class Solution {
    public int solution(String numbers) {
        List<String> list = List.of(numbers.split(""));

        for(String s : list) {
            List<String> numList = new ArrayList<>(List.copyOf(list));
            numList.remove(s);
            check(s, numList);
        }

        System.out.println(numSet);
        for(String s : numSet) {
            if(isPrime(s)) count++;
        }

        return count;
    }

    private int count;
    private final Set<String> numSet = new HashSet<>();

    private void check(String s, List<String> list) {
        numSet.add(s);

        for(String num : list) {
            List<String> numList = new ArrayList<>(List.copyOf(list));
            numList.remove(num);
            if("0".equals(s)) {
                check(num, numList);
            } else {
                check(s + num, numList);
            }
        }
    }

    private boolean isPrime(String s) {
        int num = Integer.parseInt(s);
        if(num <= 1) return false;
        for(int i = 2 ; (i * i) <= num ; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}