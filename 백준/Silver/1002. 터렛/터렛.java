import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            sb.append(getIntersectionCount(x1, y1, r1, x2, y2, r2)).append('\n');
        }

        System.out.print(sb.toString());
    }

    private static int getIntersectionCount(int x1, int y1, int r1,
                                            int x2, int y2, int r2) {
        // 같은 원 (중심, 반지름 동일)
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }

        long dx = x1 - x2;
        long dy = y1 - y2;
        long d2 = dx * dx + dy * dy;      // 거리 제곱

        long sum = r1 + r2;
        long sum2 = sum * sum;           // (r1 + r2)^2

        long diff = Math.abs(r1 - r2);
        long diff2 = diff * diff;        // (|r1 - r2|)^2

        // 교점 0개
        if (d2 > sum2 || d2 < diff2) {
            return 0;
        }

        // 교점 1개 (외접 또는 내접)
        if (d2 == sum2 || d2 == diff2) {
            return 1;
        }

        // 그 외는 항상 2개
        return 2;
    }
}
