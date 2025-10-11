class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int originalOne = countOne(n);
        
        while(true){
            n += 1;
            int one = countOne(n);
            if(one == originalOne) break;
        }
        answer = n;

        return answer;
    }
    
    private int countOne(int n) {
        final char[] ca = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        
        for(int i = 0 ; i < ca.length ; i++) {
            if(ca[i] == '1') count++;
        }
        
        return count;
    }
}