import java.util.*;

class Solution {
    private Map<String, Member> map = new HashMap<>();
    
    private class Member {
        String name, pName;
        int sum = 0;
        
        private Member(String n, String pn) {
            this.name = n;
            this.pName = pn;
        }
        
        private void add(int money) {
            if (money == 0) return;
            this.sum += money - (money / 10);
            if (pName.equals("-")) return;
            map.get(pName).add(money / 10);
        }
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        for (int i = 0 ; i < enroll.length ; i++) {
            String n = enroll[i];
            String pn = referral[i];
            
            Member m = new Member(n, pn);
            map.put(n, m);
        }
        
        for (int i = 0 ; i < seller.length ; i++) {
            map.get(seller[i]).add(amount[i] * 100);
        }
        
        for (int i = 0 ; i < enroll.length ; i++) {
            String name = enroll[i];
            answer[i] = map.get(name).sum;
        }
        
        return answer;
    }
}