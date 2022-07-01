import java.io.*;

public class BJ_12965_배낭 {
    static int N, K;
    static int[] weight;
    static int[] value;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        input();
        knapsack();
        System.out.println(dp[N][K]);
    }
    
    public static void input() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] splited = in.readLine().split(" ");
        N = Integer.parseInt(splited[0]);
        K = Integer.parseInt(splited[1]);
        weight = new int[N + 1];
        value = new int[N + 1];
        dp = new int[N + 1][K + 1];

        for (int i = 0; i < N; i++) {
            splited = in.readLine().split(" ");
            weight[i + 1] = Integer.parseInt(splited[0]);
            value[i + 1] = Integer.parseInt(splited[1]);
        }
    }

    public static void knapsack() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j - weight[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
    }
}
