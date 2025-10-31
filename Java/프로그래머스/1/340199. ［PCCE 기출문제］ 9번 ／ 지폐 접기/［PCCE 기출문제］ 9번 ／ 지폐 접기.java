class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        final int walletA = wallet[0];
        final int walletB = wallet[1];
        int billA = bill[0];
        int billB = bill[1];
        
        while(Math.max(billA, billB) > Math.max(walletA, walletB) || Math.min(billA, billB) > Math.min(walletA, walletB)) {
            answer++;
            
            if(billA > billB) {
                billA = billA / 2;
            } else {
                billB = billB / 2;
            }  
        }
        
        return answer;
    }
}