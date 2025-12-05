import java.util.*;

class Solution {
    private class File{
        final int idx;
        final String name;
        final String head;
        final int number;
        
        private File(int idx, String name, String head, int number) {
            this.idx = idx;
            this.name = name;
            this.head = head;
            this.number = number;
        }
        
        private String getHead() {
            return head;
        }
        
        private int getNumber() {
            return number;
        }
    }
    
    public String[] solution(String[] files) {
        final int l = files.length;
        String[] answer = new String[l];
        List<File> result = new ArrayList<>();
        
        for(int idx = 0 ; idx < l ; idx++) {
            String f = files[idx];
            
            boolean found = false;
            int numStart = 0;
            int numEnd = f.length();
            for(int i = 0 ; i < f.length() ; i++) {
                if(!found && Character.isDigit(f.charAt(i))) {
                    numStart = i;
                    found = true;
                }
                if(found && !Character.isDigit(f.charAt(i))) {
                    numEnd = i;
                    break;
                }
            }
            
            String head = f.substring(0, numStart).toLowerCase();
            final int number = Integer.parseInt(f.substring(numStart, numEnd));
            File file = new File(idx, f, head, number);
            result.add(file);
        }
        
        result.sort(Comparator.comparing(File::getHead)
                   .thenComparing(File::getNumber));
        
        for(int i = 0 ; i < l ; i++) {
            answer[i] = result.get(i).name;
        }
        
        return answer;
    }
}