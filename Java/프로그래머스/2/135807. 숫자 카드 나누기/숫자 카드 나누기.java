class Solution {
    private int l = 0;
    
    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private int getArrayGCD(int[] array) {
        int result = array[0];
        
        for (int i = 1 ; i < l ; i++) {
            result = getGCD(result, array[i]);
        }
        
        return result;
    }
    
    private boolean checkArray(int num, int[] array) {
        for (int n : array) {
            if (n % num == 0) return false;
        }
        return true;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        l = arrayA.length;
        
        int gcdA = getArrayGCD(arrayA);
        int gcdB = getArrayGCD(arrayB);
        
        if (gcdA == gcdB) return 0;
        
        for (int i = 1 ; i * i <= gcdA ; i++) {
            if (gcdA % i == 0) {
                if (checkArray(i, arrayB)) answer = Math.max(i, answer);
                if (checkArray(gcdA / i, arrayB)) answer = Math.max(gcdA / i, answer);
            }
        }
        
        for (int i = 1 ; i * i <= gcdB ; i++) {
            if (gcdB % i == 0) {
                if (checkArray(i, arrayA)) answer = Math.max(i, answer);
                if (checkArray(gcdB / i, arrayA)) answer = Math.max(gcdB / i, answer);
            }
        }
        
        return answer;
    }
}