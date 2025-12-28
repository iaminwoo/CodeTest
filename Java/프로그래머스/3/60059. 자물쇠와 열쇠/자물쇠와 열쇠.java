import java.util.*;

class Solution {
    private boolean isMatch(List<int[]> A, int[][] key) {
        if (V.isEmpty()) return true;
        
        // 이동거리 찾기
        List<int[]> moves = new ArrayList<>();
        for (int[] a : A) {
            for (int[] v : V) {
                moves.add(new int[]{v[0] - a[0], v[1] - a[1]});
            }
        }
        
        for (int[] arr : moves) {
            boolean match = true;
            
            for (int a = 0 ; a < LL ; a++) {
                for (int b = 0 ; b < LL ; b++) {
                    // 이동된 열쇠와 홈이 맞는지 확인
                    int keyValue = 0;
                    if (a - arr[0] >= 0 && a - arr[0] < KL && b - arr[1] >= 0 && b - arr[1] < KL) {
                        keyValue = key[a - arr[0]][b - arr[1]];
                    }
                    
                    if (L[a][b] + keyValue != 1) {
                        match = false;
                        break;
                    }
                }
                if (!match) break;
            }
            if (match) return true;
        }
        
        return false;
    }
    
    private final List<int[]> V = new ArrayList<>();
    private int[][] L;
    private int KL;
    private int LL;
    
    public boolean solution(int[][] key, int[][] lock) {
        L = lock;
        KL = key.length;
        LL = lock.length;
        
        // key 돌리기 및 돌기 찾기
        int[][] key90 = new int[KL][KL];
        int[][] key180 = new int[KL][KL];
        int[][] key270 = new int[KL][KL];
        
        List<int[]> A = new ArrayList<>();
        List<int[]> A90 = new ArrayList<>();
        List<int[]> A180 = new ArrayList<>();
        List<int[]> A270 = new ArrayList<>();
        
        for (int a = 0 ; a < KL ; a++) {
            for (int b = 0 ; b < KL ; b++) {
                int ra = KL - a - 1;
                int rb = KL - b - 1;
                
                int num = key[a][b];
                
                key90[b][ra] = num;
                key180[ra][rb] = num;
                key270[rb][a] = num;
                
                if (num == 1) {
                    A.add(new int[]{a, b});
                    A90.add(new int[]{b, ra});
                    A180.add(new int[]{ra, rb});
                    A270.add(new int[]{rb, a});
                }
            }
        }
        
        // 홈 찾기
        for (int a = 0 ; a < LL ; a++) {
            for (int b = 0 ; b < LL ; b++) {
                if (lock[a][b] == 0) {
                    V.add(new int[]{a, b});
                }
            }
        }
        
        return isMatch(A, key) || isMatch(A90, key90) || isMatch(A180, key180) || isMatch(A270, key270);
    }
}