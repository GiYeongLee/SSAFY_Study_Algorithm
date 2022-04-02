import java.io.*;

public class BJ_2579_계단오르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		if(N == 1) {
			System.out.println(arr[1]);
			return;
		}

		int[] dp = new int[N + 1];
		
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		
		for(int i = 3; i <= N; i++) {
			dp[i] = Math.max(arr[i] + dp[i - 2], arr[i] + dp[i - 3] + arr[i - 1]);
		}
		
		System.out.println(dp[N]);
	}

}
