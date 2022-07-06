public class 타일링 {
    public static void main(String[] args) {
        int n = 5000;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        if (n % 2 != 0) {
            return 0;
        }

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[2] = 3;
        
        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for (int j = 0; j <= i - 4; j += 2) {
                dp[i] += dp[j] * 2;
            }
            dp[i] %= 1000000007;
        }

        return (int)dp[n];
    }
}
