import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        List<String> spoiledMessage = new ArrayList<>();
        Set<String> noSpoiledMessage = new HashSet<>();
        int currIdx = 0;

        for (String word : message.split(" ")) {
            int start = message.indexOf(word, currIdx);
            int end = start + word.length() - 1;
            currIdx = end + 1;

            boolean isSpoiler = false;

            for (int[] idx : spoiler_ranges) {
                if (start <= idx[1] && end >= idx[0]) {
                    spoiledMessage.add(word);
                    isSpoiler = true;
                    break;
                }
            }

            if (!isSpoiler) {
                noSpoiledMessage.add(word);
            }
        }

        Set<String> importantMessage = new HashSet<>();

        for (String spoilerWord : spoiledMessage) {
            if (!noSpoiledMessage.contains(spoilerWord)) {
                importantMessage.add(spoilerWord);
            }
        }

        answer = importantMessage.size();
        return answer;
    }
}