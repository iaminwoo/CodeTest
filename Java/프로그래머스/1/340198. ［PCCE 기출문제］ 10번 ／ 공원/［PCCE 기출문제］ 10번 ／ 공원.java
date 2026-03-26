import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int[][] possibleMat = new int[park.length][park[0].length];
        int maxMat = 0;
        
        for (int i = 0 ; i < park.length ; i++) {
            for (int j = 0 ; j < park[0].length ; j++) {
                if (park[i][j].equals("-1")) {
                    int min = Integer.MAX_VALUE;
                    if (i > 0 && j > 0) {
                        min = Math.min(possibleMat[i - 1][j], min);
                        min = Math.min(possibleMat[i][j - 1], min);
                        min = Math.min(possibleMat[i - 1][j - 1], min);
                    } else {
                        min = 0;
                    }
                    
                    possibleMat[i][j] = min + 1;
                    maxMat = Math.max(maxMat, possibleMat[i][j]);
                }
            }
        }
        
        Arrays.sort(mats);
        int answer = -1;
        
        for (int i = 0 ; i < mats.length ; i++) {
            if (mats[i] > maxMat) break;
            answer = mats[i];
        }
        
        return answer;
    }
}