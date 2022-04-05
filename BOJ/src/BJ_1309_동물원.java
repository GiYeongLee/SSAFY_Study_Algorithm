import java.io.*;

public class BJ_1309_동물원 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] dp = new int[N + 1];
		
		if(N == 0) {
			System.out.println(1);
			return;
		}
		
		dp[0] = 1;
		dp[1] = 1 + 2;	// 3
		//dp[3] = 1 + 6 + 8 + 2;	// 17
		//dp[4] = 41;
		
		for(int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1] * 2) % 9901;
		}

		System.out.println(dp[N]);

	}

}
