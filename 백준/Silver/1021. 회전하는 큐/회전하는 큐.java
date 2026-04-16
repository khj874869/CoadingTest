import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int answer = 0;

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            int idx = deque.indexOf(target);
            int leftMoves = idx;
            int rightMoves = deque.size() - idx;

            if (leftMoves <= rightMoves) {
                for (int j = 0; j < leftMoves; j++) {
                    deque.addLast(deque.removeFirst());
                    answer++;
                }
            } else {
                for (int j = 0; j < rightMoves; j++) {
                    deque.addFirst(deque.removeLast());
                    answer++;
                }
            }

            deque.removeFirst();
        }

        System.out.println(answer);
    }
}