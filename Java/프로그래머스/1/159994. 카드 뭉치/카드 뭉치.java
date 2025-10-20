class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int pointer1 = 0;
        int pointer2 = 0;
        
        for(String s : goal) {
            if(pointer1 < cards1.length && cards1[pointer1].equals(s)) {
                pointer1++;
            } else if(pointer2 < cards2.length && cards2[pointer2].equals(s)) {
                pointer2++;
            } else {
                return "No";
            }
        }
        
        
        return "Yes";
    }
}