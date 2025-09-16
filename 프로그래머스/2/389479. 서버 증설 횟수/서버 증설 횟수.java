import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0, currentServerCnt = 0;
        PriorityQueue<Server> activeServers = new PriorityQueue<>((a, b) -> a.end - b.end);

        for (int t = 0; t < 24; t++) {
            int people = players[t];

            while (!activeServers.isEmpty() && activeServers.peek().end < t) {
                currentServerCnt -= activeServers.poll().cnt;
            }

            int needServerCnt = Math.max(0, people / m - currentServerCnt);

            if (needServerCnt > 0) {
                activeServers.add(new Server(needServerCnt, t + k - 1));
                currentServerCnt += needServerCnt;
                answer += needServerCnt;
            }
        }

        return answer;
    }

    private class Server {
        int end, cnt;

        private Server(int cnt, int end) {
            this.cnt = cnt;
            this.end = end;
        }
    }
}