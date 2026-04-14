import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to;
        long w;

        Edge(int to, long w) {
            this.to = to;
            this.w = w;
        }
    }

    static int n, m;
    static long k;
    static ArrayList<Edge>[] g;
    static ArrayList<Integer>[] rg;

    static boolean[] visited;
    static int[] comp;
    static ArrayList<Integer> order = new ArrayList<>();

    static long[] value;
    static boolean[] assigned;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        n = fs.nextInt();
        m = fs.nextInt();
        k = fs.nextLong();

        g = new ArrayList[n + 1];
        rg = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
            rg[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            long w = fs.nextLong() % k;
            g[u].add(new Edge(v, w));
            rg[v].add(u);
        }

        // 1) First pass: get finishing order
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfsOrderIterative(i);
            }
        }

        // 2) Second pass on reversed graph: assign SCC ids
        comp = new int[n + 1];
        Arrays.fill(comp, -1);

        int compCnt = 0;
        for (int i = order.size() - 1; i >= 0; i--) {
            int v = order.get(i);
            if (comp[v] == -1) {
                assignComponentIterative(v, compCnt++);
            }
        }

        // 3) Check consistency only inside each SCC
        value = new long[n + 1];
        assigned = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!assigned[i]) {
                assigned[i] = true;
                value[i] = 0;

                if (!checkComponentIterative(i)) {
                    System.out.println("No");
                    return;
                }
            }
        }

        System.out.println("Yes");
    }

    static void dfsOrderIterative(int start) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{start, 0});
        visited[start] = true;

        while (!stack.isEmpty()) {
            int[] top = stack.peek();
            int v = top[0];
            int idx = top[1];

            if (idx < g[v].size()) {
                Edge e = g[v].get(idx);
                top[1]++;

                if (!visited[e.to]) {
                    visited[e.to] = true;
                    stack.push(new int[]{e.to, 0});
                }
            } else {
                stack.pop();
                order.add(v);
            }
        }
    }

    static void assignComponentIterative(int start, int id) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        comp[start] = id;

        while (!stack.isEmpty()) {
            int v = stack.pop();
            for (int prev : rg[v]) {
                if (comp[prev] == -1) {
                    comp[prev] = id;
                    stack.push(prev);
                }
            }
        }
    }

    static boolean checkComponentIterative(int start) {
        int cid = comp[start];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int u = stack.pop();

            for (Edge e : g[u]) {
                if (comp[e.to] != cid) continue; // Ignore edges leaving the SCC

                long need = (value[u] + e.w) % k;

                if (!assigned[e.to]) {
                    assigned[e.to] = true;
                    value[e.to] = need;
                    stack.push(e.to);
                } else {
                    if (value[e.to] != need) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            long sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}