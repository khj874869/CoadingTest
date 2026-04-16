import java.io.*;
import java.util.*;

public class Main {
    static final int SIZE = 5;
    static List<int[]> pieces = new ArrayList<>();
    static List<int[]> selected = new ArrayList<>();
    static boolean[] chosen = new boolean[25];
    static int k;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < SIZE; i++) {
            String line = br.readLine();
            for (int j = 0; j < SIZE; j++) {
                if (line.charAt(j) == '*') {
                    pieces.add(new int[]{i, j});
                }
            }
        }

        k = pieces.size();

        if (k == 1) {
            System.out.println(0);
            return;
        }

        comb(0, 0);
        System.out.println(answer);
    }

    static void comb(int idx, int cnt) {
        if (cnt == k) {
            if (isConnected()) {
                answer = Math.min(answer, calcMinMove());
            }
            return;
        }

        if (idx == 25) return;

        chosen[idx] = true;
        selected.add(new int[]{idx / 5, idx % 5});
        comb(idx + 1, cnt + 1);

        chosen[idx] = false;
        selected.remove(selected.size() - 1);
        comb(idx + 1, cnt);
    }

    static boolean isConnected() {
        boolean[][] board = new boolean[5][5];
        for (int[] p : selected) {
            board[p[0]][p[1]] = true;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        int[] start = selected.get(0);
        q.offer(start);
        visited[start[0]][start[1]] = true;

        int count = 1;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                if (!board[nr][nc] || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
                count++;
            }
        }

        return count == k;
    }

    static int calcMinMove() {
        boolean[] used = new boolean[k];
        return perm(0, used, 0);
    }

    static int perm(int depth, boolean[] used, int sum) {
        if (sum >= answer) return Integer.MAX_VALUE;
        if (depth == k) return sum;

        int min = Integer.MAX_VALUE;

        int[] from = pieces.get(depth);
        for (int i = 0; i < k; i++) {
            if (used[i]) continue;
            used[i] = true;

            int[] to = selected.get(i);
            int dist = Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);
            min = Math.min(min, perm(depth + 1, used, sum + dist));

            used[i] = false;
        }

        return min;
    }
}