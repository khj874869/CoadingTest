class Solution {
    public int solution(int[][] signals) {
        long totalCycle = 1;

        for (int[] signal : signals) {
            int cycle = signal[0] + signal[1] + signal[2];
            totalCycle = lcm(totalCycle, cycle);
        }

        for (long t = 1; t <= totalCycle; t++) {
            boolean allYellow = true;

            for (int[] signal : signals) {
                int g = signal[0];
                int y = signal[1];
                int r = signal[2];
                int cycle = g + y + r;

                
                long offset = (t - 1) % cycle;

              
                if (!(g <= offset && offset < g + y)) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) {
                return (int) t;
            }
        }

        return -1;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}