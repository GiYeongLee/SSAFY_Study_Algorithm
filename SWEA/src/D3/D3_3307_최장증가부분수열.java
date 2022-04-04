package D3;

import java.io.*;

public class D3_3307_최장증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= TC; t++) {
			
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[N + 1];
			int[] dp = new int[N + 1];
			
			String[] splited = in.readLine().split(" ");
			for(int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(splited[i - 1]);
			}
			
			int answer = Integer.MIN_VALUE;
			
			for(int i = 1; i <= N; i++) {
				dp[i] = 1;
				
				for(int j = 1; j <= i; j++) {
					if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}	
				}
				
				answer = Math.max(answer, dp[i]);
			}
			
			System.out.println("#" + t + " " + answer);		
		}
	}
}
