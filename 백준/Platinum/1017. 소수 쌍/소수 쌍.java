import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) { this.in = in; }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do { c = readByte(); } while (c <= ' ' && c != -1);
            int sign = 1;
            if (c == '-') { sign = -1; c = readByte(); }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    static boolean[] isPrime;
    static List<Integer>[] adj;     // left(A) -> right(B) edges
    static int[] matchR;            // matchR[b] = a (index in left), or -1
    static boolean[] visited;

    static boolean dfs(int a, int fixedB) {
        for (int b : adj[a]) {
            if (b == fixedB) continue;     // fixed partner is reserved for A0
            if (visited[b]) continue;
            visited[b] = true;

            if (matchR[b] == -1 || dfs(matchR[b], fixedB)) {
                matchR[b] = a;
                return true;
            }
        }
        return false;
    }

    static boolean[] sieve(int max) {
        boolean[] prime = new boolean[max + 1];
        Arrays.fill(prime, true);
        if (max >= 0) prime[0] = false;
        if (max >= 1) prime[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if (!prime[i]) continue;
            for (int j = i * i; j <= max; j += i) prime[j] = false;
        }
        return prime;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int N = fs.nextInt();
        int[] arr = new int[N];
        int maxVal = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = fs.nextInt();
            maxVal = Math.max(maxVal, arr[i]);
        }

        // primes up to max sum
        isPrime = sieve(maxVal * 2);

        int first = arr[0];
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        // A: same parity as first, B: opposite parity
        for (int x : arr) {
            if ((x & 1) == (first & 1)) A.add(x);
            else B.add(x);
        }

        // perfect matching requires same size in bipartite setting
        if (A.size() != B.size()) {
            System.out.print("-1");
            return;
        }

        int LA = A.size();
        int LB = B.size();

        // Build adjacency
        adj = new ArrayList[LA];
        for (int i = 0; i < LA; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < LA; i++) {
            for (int j = 0; j < LB; j++) {
                if (isPrime[A.get(i) + B.get(j)]) {
                    adj[i].add(j);
                }
            }
        }

        // Candidates are neighbors of A[0]
        List<Integer> answers = new ArrayList<>();
        for (int candB : adj[0]) {
            matchR = new int[LB];
            Arrays.fill(matchR, -1);

            // Fix A0 - candB
            matchR[candB] = 0;

            int matched = 0;
            for (int a = 1; a < LA; a++) {
                visited = new boolean[LB];
                if (dfs(a, candB)) matched++;
                else break;
            }

            if (matched == LA - 1) {
                answers.add(B.get(candB));
            }
        }

        if (answers.isEmpty()) {
            System.out.print("-1");
        } else {
            Collections.sort(answers);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < answers.size(); i++) {
                if (i > 0) sb.append(' ');
                sb.append(answers.get(i));
            }
            System.out.print(sb.toString());
        }
    }
}
