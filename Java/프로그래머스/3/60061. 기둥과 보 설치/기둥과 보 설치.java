import java.util.*;

class Solution {
    private List<int[]> build = new ArrayList<>();
    private int N;
    
    private boolean checkBuild() {
        // 안전하면 true
        for (int[] b : build) {
            boolean isSafe = false;
            int x = b[0];
            int y = b[1];
            
            if (b[2] == 0) {
                // 기둥 안전체크
                if (y == 0 || checkFor(x - 1, y, 1) || checkFor(x, y, 1) || checkFor(x, y - 1, 0)) {
                    isSafe = true;
                }
            } else {
                // 보 안전체크
                if (checkFor(x, y - 1, 0) || checkFor(x + 1, y - 1, 0)
                    || (checkFor(x - 1, y, 1) && checkFor(x + 1, y, 1))) {
                    isSafe = true;
                }
            }
            
            if (!isSafe) return false;
        }
        return true;
    }
    
    private boolean checkFor(int x, int y, int v) {
        if (x < 0 || N < x || y < 0 || N < y) return false;
        
        boolean found = false;
        for (int[] b : build) {
            if (Arrays.equals(new int[]{x, y, v}, b)) {
                found = true;
                break;
            }
        }
        return found;
    }
    
    private void addBuild(int x, int y, int v) {
        if (v == 0) {
            // 기둥
            if (y == 0 || checkFor(x - 1, y, 1) || checkFor(x, y, 1) || checkFor(x, y - 1, 0)) {
                build.add(new int[]{x, y, v});
            }
        } else {
            // 보
            if (checkFor(x, y - 1, 0) || checkFor(x + 1, y - 1, 0)
                || (checkFor(x - 1, y, 1) && checkFor(x + 1, y, 1))) {
                build.add(new int[]{x, y, v});
            }
        }
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        N = n;
        
        for (int[] bf : build_frame) {
            int x = bf[0];
            int y = bf[1];
            
            if (bf[3] == 0) {
                // 대상 조회
                int[] target = null;
                for (int[] b : build) {
                    if (Arrays.equals(new int[]{x, y, bf[2]}, b)) {
                        target = b;
                        break;
                    }
                }
                
                if (target != null) {
                    // 대상 제거
                    build.remove(target);
                    
                    // 구조물 확인
                    if (!checkBuild()) {
                        // 안전하지 않으면 롤백
                        build.add(target);
                    }
                }
                
            } else {
                // 설치
                addBuild(x, y, bf[2]);
            }
        }
        
        return build.stream()
            .sorted((a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[2], b[2]);
            })
            .toArray(int[][]::new);
    }
}