class Solution {
    public String solution(String new_id) {
        String newi = new_id.toLowerCase();

        newi = newi.replaceAll("[^a-z0-9-_.]", "");

        newi = newi.replaceAll("\\.{2,}", ".");

        newi = newi.replaceAll("^\\.|\\.$", "");

        if (newi.equals("")) {
            newi = "a";
        }

        if (newi.length() >= 16) {
            newi = newi.substring(0, 15);
            newi = newi.replaceAll("\\.$", "");
        }

        if (newi.length() <= 2) {
            char lastChar = newi.charAt(newi.length() - 1);
            while (newi.length() < 3) {
                newi += lastChar;
            }
        }

        String answer = newi;
        return answer;
    }
}