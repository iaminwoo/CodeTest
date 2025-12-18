import java.util.*;

class Solution {
    private String makeRightStr(String p) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if (p.isEmpty() || isRightStr(p)) return p;
        
        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
        int left = 0;
        int right = 0;
        for (int i = 0 ; i < p.length() ; i++) {
            if (p.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) break;
        }
        String u = p.substring(0, left + right);
        String v = p.substring(left + right, p.length());
        
        if (isRightStr(u)) {
            // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
            // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            return u + makeRightStr(v);
        } else {
            // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
            // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            StringBuilder result = new StringBuilder("(");
            
            // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            result.append(makeRightStr(v));

            // 4-3. ')'를 다시 붙입니다.
            result.append(')');

            // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            result.append(flip(u.substring(1, u.length() - 1)));

            // 4-5. 생성된 문자열을 반환합니다.
            return result.toString();
        }
    }
    
    private boolean isRightStr(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            
            if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
    
    private String flip(String s) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == ')') {
                result.append('(');
            } else {
                result.append(')');
            }
        }
        
        return result.toString();
    }
    
    public String solution(String p) {
        return makeRightStr(p);
    }
}