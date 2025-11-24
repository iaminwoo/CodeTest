import java.util.*;

class Solution {
    private String check(String str, int idx) {
        String temp = str.substring(idx, idx + 2);
        if(temp.charAt(0) < 97 || temp.charAt(0) > 122) return "";
        if(temp.charAt(1) < 97 || temp.charAt(1) > 122) return "";
        return temp;
    }
    
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        List<String> list1 = new ArrayList<>();
        for(int i = 0 ; i < str1.length() - 1 ; i++) {
            String e = check(str1, i);
            if(!e.isBlank())list1.add(e);
        }
        
        List<String> list2 = new ArrayList<>();
        for(int i = 0 ; i < str2.length() - 1 ; i++) {
            String e = check(str2, i);
            if(!e.isBlank())list2.add(e);
        }
        
        List<String> bigger;
        List<String> smaller;
        if(list1.size() < list2.size()) {
            bigger = new ArrayList<>(list2);
            smaller = list1;
        } else {
            bigger = new ArrayList<>(list1);
            smaller = list2;
        }
        
        double i = 0;
        
        for(String s : smaller) {
            if(bigger.remove(s)) i++;
        }
        
        double u = list1.size() + list2.size() - i;
        
        if(i == 0 && u == 0) return 65536;
        return (int) ((i / u) * 65536);
    }
}