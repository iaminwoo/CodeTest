import java.util.*;

class Solution {
    private class Data {
        int code;
        int date;
        int maximum;
        int remain;
        
        private Data(int c, int d, int m, int r) {
            code = c;
            date = d;
            maximum = m;
            remain = r;
        }
        
        private int value(String ext) {
            switch (ext) {
                case "code" : return code;
                case "date" : return date;
                case "maximum" : return maximum;
                case "remain" : return remain;
                default: return 0;
            }
        }
    }
    
    private int[][] toAnswer(List<Data> result) {
        int[][] answer = new int[result.size()][4];
        
        for (int i = 0 ; i < result.size() ; i++) {
            Data d = result.get(i);
            answer[i] = new int[]{d.code, d.date, d.maximum, d.remain};
        }
        
        return answer;
    }
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<Data> list = new ArrayList<>();
        for (int i = 0 ; i < data.length ; i++) {
            list.add(new Data(data[i][0], data[i][1], data[i][2], data[i][3]));
        }
        
        List<Data> result = new ArrayList<>();
        for (Data d : list) {
            if (d.value(ext) < val_ext) {
                result.add(d);
            }
        }
        
        result.sort((a, b) -> a.value(sort_by) - b.value(sort_by));
        
        return toAnswer(result);
    }
}