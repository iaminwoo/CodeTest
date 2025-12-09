class Solution {
    public int solution(int[] queue1, int[] queue2) {
        final int l = queue1.length;
        
        int[] newArr = new int[l * 4];
        long total = 0;
        
        for (int i = 0 ; i < l ; i++) {
            newArr[i] = queue1[i];
            newArr[l * 2 + i] = queue1[i];
            total += queue1[i];
        }
        
        for (int i = 0 ; i < queue2.length ; i++) {
            newArr[l + i] = queue2[i];
            newArr[l * 3 + i] = queue2[i];
            total += queue2[i];
        }
        
        final long n = total / 2;
        if (total % 2 != 0) return -1;
        
        int start = 0;
        int end = l;
        
        long sum = 0;
        for (int i = start ; i < end ; i++) {
            sum += newArr[i];
        }
        
        int count = 0;
        while (n != sum) {
            if (count > l * 4) return -1;
            
            count++;
            
            if (n > sum) {
                sum += newArr[end++];
            } else {
                sum -= newArr[start++];
            }
        }
        
        return count;
    }
}