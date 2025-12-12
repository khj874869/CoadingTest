import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    
    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp[0][0] = 1; // N=0 일 때, 0은 1번 출력
        dp[0][1] = 0; // N=0 일 때, 1은 0번 출력
        dp[1][0] = 0; // N=1 일 때, 0은 0번 출력
        dp[1][1] = 1; // N=1 일 때, 1은 1번 출력

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append('\n');
        }
        
        System.out.print(sb);
    }

    static Integer[] fibonacci(int N) {
        if (dp[N][0] == null || dp[N][1] == null) {
            Integer[] nMinus1 = fibonacci(N - 1);
            Integer[] nMinus2 = fibonacci(N - 2);

            dp[N][0] = nMinus1[0] + nMinus2[0];
            dp[N][1] = nMinus1[1] + nMinus2[1];
        }
        
        return dp[N];
    }
}