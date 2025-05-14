public class Solution {
    public String solution(String new_id) {
        String result = new_id.toLowerCase().replaceAll("[^a-z0-9-_.]", "")
                .replaceAll("[.]+", ".");
        if(result.startsWith(".")) result = result.substring(1);
        if(result.endsWith(".")) result = result.substring(0, result.length()-1);
        if(result.isEmpty()) result = "a";
        if(result.length() >= 16) result = result.substring(0, 15);
        if(result.endsWith(".")) result = result.substring(0, result.length()-1);
        if(result.length() <= 2) result += ("" + result.charAt(result.length()-1)).repeat(3 - result.length());

        return result;
    }
}