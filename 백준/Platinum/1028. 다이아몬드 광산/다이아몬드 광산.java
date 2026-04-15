import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int R, C;
    static int[][] map;
    static int[][] ld; 
    static int[][] rd; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        ld = new int[R][C];
        rd = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = R - 1; i >= 0; i--) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 1) {
                    ld[i][j] = 1;
                    rd[i][j] = 1;

                    if (i + 1 < R && j - 1 >= 0) {
                        ld[i][j] = Math.max(ld[i][j], ld[i + 1][j - 1] + 1);
                    }
                    if (i + 1 < R && j + 1 < C) {
                        rd[i][j] = Math.max(rd[i][j], rd[i + 1][j + 1] + 1);
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) continue;

                int maxSize = Math.min(ld[i][j], rd[i][j]);

                for (int size = maxSize; size > answer; size--) {
                    int nr = i + size - 1;
                    int leftCol = j - size + 1;
                    int rightCol = j + size - 1;

                    if (nr >= R || leftCol < 0 || rightCol >= C) continue;

                    if (rd[nr][leftCol] >= size && ld[nr][rightCol] >= size) {
                        answer = size;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}