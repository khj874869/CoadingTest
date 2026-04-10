class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int n = cost.length;
        long answer = Long.MAX_VALUE;

        for (int mask = 0; mask < (1 << (n - 1)); mask++) {
            int[] hints = new int[n];   
            long total = 0;
            for (int i = 0; i < n; i++) {
                int use = Math.min(hints[i], n - 1);
                total += cost[i][use];
                if (i < n - 1 && (mask & (1 << i)) != 0) {
                    total += hint[i][0]; 
                    for (int j = 1; j < hint[i].length; j++) {
                        int stageNumber = hint[i][j]; 
                        hints[stageNumber - 1]++;
                    }
                }
            }
            answer = Math.min(answer, total);
        }

        return (int) answer;
    }
}