import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int idx = 0;
        
        int[][] arr = new int[rows][columns];
        for (int a = 0 ; a < rows ; a++) {
            for (int b = 0 ; b < columns ; b++) {
                arr[a][b] = a * columns + b + 1;
            }
        }
        
        for (int[] q : queries) {
            int min = Integer.MAX_VALUE;
            
            int a0 = q[0] - 1;
            int b0 = q[1] - 1;
            int an = q[2] - 1;
            int bn = q[3] - 1;

            int temp = arr[a0][b0];

            // 1. left
            for (int a = a0 + 1 ; a <= an ; a++) {
                arr[a - 1][b0] = arr[a][b0];
                min = Math.min(min, arr[a][b0]);
            }

            // 2. down
            for (int b = b0 + 1 ; b <= bn ; b++) {
                arr[an][b - 1] = arr[an][b];
                min = Math.min(min, arr[an][b]);
            }

            // 3. right
            for (int a = an - 1 ; a >= a0 ; a--) {
                arr[a + 1][bn] = arr[a][bn];
                min = Math.min(min, arr[a][bn]);
            }

            // 4. up
            for (int b = bn - 1 ; b >= b0 + 1 ; b--) {
                arr[a0][b + 1] = arr[a0][b];
                min = Math.min(min, arr[a0][b]);
            }

            arr[a0][b0 + 1] = temp;
            min = Math.min(min, temp);

            answer[idx++] = min;
        }
        
        return answer;
    }
}