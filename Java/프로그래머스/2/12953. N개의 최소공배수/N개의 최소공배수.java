class Solution {
    private int GCD(int a, int b) {
        if(b == 0) return a;
        return GCD(b, a%b);
    }

    private int LCM(int a, int b) {
        return (a * b) / GCD(a, b);
    }
    
    public int solution(int[] arr) {
        int answer = 0;
        
        if(arr.length == 1) return arr[0];
        
        answer = LCM(arr[0], arr[1]);
        for(int i = 2 ; i < arr.length ; i++) {
            answer = LCM(answer, arr[i]);
        }
        
        return answer;
    }
}