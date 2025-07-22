import java.util.*;

class Solution {
    private static class Word {
        private final String s;
        private final List<Integer> nextWords;
        private final int depth;
        
        private Word(int before, String s, String[] words, boolean[] wordCheck) {
            this.s = s;
            this.nextWords = new ArrayList<>();
            this.depth = before + 1;
            
            for(int i = 0 ; i < words.length ; i++) {
                int count = 0;
                for(int j = 0 ; j < s.length() ; j++) {
                    if(s.charAt(j) != words[i].charAt(j)) count++;
                }
                if(count == 1 && wordCheck[i] == false) {
                    nextWords.add(i);
                }
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int count = 0;
        boolean[] wordCheck = new boolean[50];
        Queue<Word> nextWordQueue = new LinkedList<>();
        
        Word beginWord = new Word(-1, begin, words, wordCheck);
        for(int nextWordIndex : beginWord.nextWords) {
            nextWordQueue.add(new Word(beginWord.depth, words[nextWordIndex], words, wordCheck));
            wordCheck[nextWordIndex] = true;
        }
        
        while(!nextWordQueue.isEmpty()) {
            Word word = nextWordQueue.poll();
            if(word.s.equals(target)) {
                count = word.depth;
                break;
            }

            for(int nextWordIndex : word.nextWords) {
                if(wordCheck[nextWordIndex] == true) continue;
                
                nextWordQueue.add(new Word(word.depth, words[nextWordIndex], words, wordCheck));
                wordCheck[nextWordIndex] = true;
            }
        }
        
        return count;
    }
}