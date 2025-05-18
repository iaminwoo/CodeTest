import java.util.*;

public class Solution {
    public long solution(String expression) {
        long max = 0;
        String[][] opArr = {
                {"+", "-", "*"},
                {"+", "*", "-"},
                {"-", "+", "*"},
                {"-", "*", "+"},
                {"*", "+", "-"},
                {"*", "-", "+"}
        };

        String[] exArr = toArr(expression);

        for(String[] ops : opArr) {
            String[] copy = Arrays.copyOf(exArr, exArr.length);
            long result = getMax(ops, copy);
            if(result > max) max = result;
        }

        return max;
    }

    private String[] toArr(String expression) {
        char[] charArr = expression.toCharArray();
        StringBuilder num = new StringBuilder();
        List<String> sList = new ArrayList<>();

        for(char c : charArr) {
            if(Character.isDigit(c)) {
                num.append(c);
            } else {
                sList.add(num.toString());
                num.setLength(0);
                sList.add("" + c);
            }
        }
        sList.add(num.toString());

        return sList.toArray(new String[0]);
    }

    private long getMax(String[] ops, String[] exArr){
        for(String op : ops) {
            for(int i = 0 ; i < exArr.length ; i++){
                if(exArr[i].equals(op)){
                    switch(op) {
                        case "+" :
                            exArr[i+1] = String.valueOf(Long.parseLong(exArr[i-1])
                                    + Long.parseLong(exArr[i+1]));
                            break;
                        case "-" :
                            exArr[i+1] = String.valueOf(Long.parseLong(exArr[i-1])
                                    - Long.parseLong(exArr[i+1]));
                            break;
                        case "*" :
                            exArr[i+1] = String.valueOf(Long.parseLong(exArr[i-1])
                                    * Long.parseLong(exArr[i+1]));
                            break;
                    }
                    exArr[i] = null;
                    exArr[i-1] = null;
                    i++;
                }
            }
            exArr = Arrays.stream(exArr).filter(Objects::nonNull).toArray(String[]::new);
        }

        long result = Long.parseLong(exArr[0]);
        return result > 0 ? result : -result;
    }
}