import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
         if (n <= 0) {         
            int sumB = 0;
            for (int[] item : info) sumB += item[1];
            return sumB < m ? 0 : -1;
        }
        if (m <= 0) {            
            int sumA = 0;
            for (int[] item : info) sumA += item[0];
            return sumA < n ? sumA : -1;
        }

        final int INF = 1_000_000_000;
        int[] dp = new int[m]; // b = 0..m-1
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int[] item : info) {
            int aCost = item[0];
            int bCost = item[1];

            int[] ndp = new int[m];
            Arrays.fill(ndp, INF);

            for (int b = 0; b < m; b++) {
                if (dp[b] == INF) continue;             
                int newASum = dp[b] + aCost;
                if (newASum < ndp[b]) {
                    ndp[b] = newASum;
                }

              
                int nb = b + bCost;
                if (nb < m) {
                    // A 누적은 그대로
                    if (dp[b] < ndp[nb]) {
                        ndp[nb] = dp[b];
                    }
                }
            }

            dp = ndp;
        }

        int ans = INF;
        for (int b = 0; b < m; b++) {
            if (dp[b] < n) {
                ans = Math.min(ans, dp[b]);
            }
        }
        return (ans == INF) ? -1 : ans;
    }

}