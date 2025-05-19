import java.util.*;

public class Solution {
    public int solution(String[] user_id, String[] banned_id) {

        List<List<String>> matches = getMatches(user_id, banned_id);

        Set<String> selected = new HashSet<>();
        Set<Set<String>> combinations = new HashSet<>();
        findCombination(0, matches, selected, combinations);

        return combinations.size();
    }

    private List<List<String>> getMatches(String[] userId, String[] bannedId) {
        List<List<String>> matches = new ArrayList<>();
        for (int bIndex = 0 ; bIndex < bannedId.length ; bIndex++) {
            matches.add(new ArrayList<>());
            for (String uId : userId) {
                if(bannedId[bIndex].length() != uId.length()) continue;

                boolean isMatch = true;
                for (int i = 0 ; i < bannedId[bIndex].length() ; i++) {
                    if (bannedId[bIndex].charAt(i) != '*' && bannedId[bIndex].charAt(i) != uId.charAt(i)) {
                        isMatch = false;
                        break;
                    }
                }

                if(isMatch) {
                    matches.get(bIndex).add(uId);
                }
            }
        }
        return matches;
    }

    private void findCombination(int depth, List<List<String>> matches, Set<String> selected, Set<Set<String>> combinations) {
        if (depth == matches.size()) {
            combinations.add(new HashSet<>(selected));
            return;
        }

        for (String id : matches.get(depth)) {
            if (!selected.contains(id)) {
                selected.add(id);
                findCombination(depth + 1, matches, selected, combinations);
                selected.remove(id);
            }
        }
    }
}