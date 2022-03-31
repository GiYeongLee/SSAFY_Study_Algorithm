

import java.io.*;

public class BJ_1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[][] house = new int[N + 1][3];
		int[][] dp = new int[N + 1][3];
		
		for(int i = 1; i <= N; i++) {
			String[] splited = in.readLine().split(" ");
			for(int j = 0; j < 3; j++) {
				house[i][j] = Integer.parseInt(splited[j]);
				
				if(i == 1) {
					dp[1][j] = house[i][j];
				}
			}
		}
		
		for(int i = 2; i <= N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + house[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + house[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + house[i][2];
		}
		
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
		
	}

}
