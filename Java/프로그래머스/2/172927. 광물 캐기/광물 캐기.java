import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        final int pl = picks[0] + picks[1] + picks[2];
        final int ml = minerals.length;
        final int maxMineral = Math.min(pl * 5, ml);
        final int chunks = (maxMineral + 4) / 5;
        
        final int[] ms = new int[maxMineral];
        final int[][] pm = new int[chunks][3];
        
        for (int i = 0 ; i < maxMineral ; i++) {
            String s = minerals[i];
            int v = 1;
            if (s.equals("diamond")) {
                v = 25;
            } else if (s.equals("iron")) {
                v = 5;
            }
            
            pm[i / 5][0] = i / 5;
            pm[i / 5][1] += v;
            ms[i] = v;
        }
        
        Arrays.sort(pm, (a, b) -> b[1] - a[1]);
        
        int dia = picks[0];
        int iron = picks[1];
        int stone = picks[2];
        
        for (int[] chunk : pm) {
            if (dia > 0) {
                chunk[2] = 25;
                dia--;
            } else if (iron > 0) {
                chunk[2] = 5;
                iron--;
            } else if (stone > 0) {
                chunk[2] = 1;
                stone--;
            }
        }
        
        Arrays.sort(pm, (a, b) -> a[0] - b[0]);
        
        for (int i = 0 ; i < maxMineral ; i++) {
            int m = ms[i];
            int pick = pm[i / 5][2];
            
            int stamina = m / pick;
            if (stamina == 0) stamina = 1;
            
            answer += stamina;
        }
        
        return answer;
    }
}