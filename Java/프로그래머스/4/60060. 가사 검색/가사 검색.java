import java.util.*;

class Solution {
    private static class Node {
        private final Map<Integer, Integer> terminals = new HashMap();
        private final Map<Character, Node> children = new HashMap();
        
        private void add(String word, int offset) {
            int length = word.length() - offset;
            terminals.put(length, terminals.getOrDefault(length, 0) + 1);
            
            if(length > 0) {
                char c = word.charAt(offset);
                Node child = children.getOrDefault(c, new Node());
                children.put(c, child);
                child.add(word, offset + 1);
            }
        }
        
        private int count(String query, int offset) {
            char c = query.charAt(offset);
            int length = query.length() - offset;
            
            if(c == '?') {
                return terminals.getOrDefault(length, 0);
            }
            
            if(!children.containsKey(c)) {
                return 0;
            }
            
            return children.get(c).count(query, offset + 1);
        }
    }
    
    public int[] solution(String[] words, String[] queries) {
        List<Integer> answer = new ArrayList<>();
        
        Node trie = new Node();
        Node reverseTrie = new Node();
        
        for(String word : words) {
            trie.add(word, 0);
            reverseTrie.add(new StringBuilder(word).reverse().toString(), 0);
        }
        
        for(String query : queries) {
            if(query.startsWith("?")) {
                answer.add(reverseTrie.count(new StringBuilder(query).reverse().toString(), 0));
            } else {
                answer.add(trie.count(query, 0));
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}