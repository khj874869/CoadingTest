import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = new Node(value, i);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.value != b.value) {
                return Integer.compare(a.value, b.value);
            }
            return Integer.compare(a.index, b.index);
        });

        int[] p = new int[n];
        for (int pos = 0; pos < n; pos++) {
            p[arr[pos].index] = pos;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(p[i]);
            if (i < n - 1) sb.append(' ');
        }

        System.out.println(sb);
    }
}