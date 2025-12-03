class Solution {
    private class PrevRow {
        int max;
        int maxIdx;
        int secondMax;
        int smIdx;
        
        private PrevRow(int max, int maxIdx, int secondMax, int smIdx) {
            this.max = max;
            this.maxIdx = maxIdx;
            this.secondMax = secondMax;
            this.smIdx = smIdx;
        }
    }
    
    private PrevRow getMaxs(int[][] land, int row) {
        int max = 0;
        int maxIdx = 0;
        int secondMax = 0;
        int smIdx = 0;
        
        for(int i = 0 ; i < 4 ; i++) {
            int num = land[row - 1][i];
            
            if(max < num) {
                secondMax = max;
                smIdx = maxIdx;
                
                max = num;
                maxIdx = i;
            } else {
                if(secondMax < num) {
                    secondMax = num;
                    smIdx = i;
                }
            }
        }
        
        return new PrevRow(max, maxIdx, secondMax, smIdx);
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        
        for(int row = 1 ; row < land.length ; row++) {
            PrevRow prevRow = getMaxs(land, row);
            
            for(int i = 0 ; i < 4 ; i++) {
                if(i != prevRow.maxIdx) {
                    land[row][i] += prevRow.max;
                } else {
                    land[row][i] += prevRow.secondMax;
                }
            }
        }
        
        int[] lastRow = land[land.length - 1];
        for(int i = 0 ; i < 4 ; i++) {
            answer = Math.max(answer, lastRow[i]);
        }
        
        return answer;
    }
}