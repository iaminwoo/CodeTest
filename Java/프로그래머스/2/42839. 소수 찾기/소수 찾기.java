import java.util.*;

public class Solution {
    public int solution(String numbers) {
        List<String> list = List.of(numbers.split(""));
        int count = 0;
        final Set<Integer> numSet = new HashSet<>();

        for(String s : list) {
            List<String> numList = new ArrayList<>(List.copyOf(list));
            numList.remove(s);
            check(s, numList, numSet);
        }

        for(int s : numSet) {
            if(isPrime(s)) count++;
        }

        return count;
    }

    private void check(String s, List<String> list, Set<Integer> numSet) {
        numSet.add(Integer.parseInt(s));

        for(String num : list) {
            List<String> numList = new ArrayList<>(List.copyOf(list));
            numList.remove(num);
            check(s + num, numList, numSet);
        }
    }

    private boolean isPrime(int num) {
        if(num <= 1) return false;
        for(int i = 2 ; (i * i) <= num ; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
