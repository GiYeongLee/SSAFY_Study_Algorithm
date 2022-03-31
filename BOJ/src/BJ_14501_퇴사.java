import java.io.*;
import java.util.*;

public class BJ_14501_퇴사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] time = new int[N + 2];
		int[] money = new int[N + 2];
		int[] dp = new int[N + 2];
		
		for(int i = 1; i <= N; i++) {
			String[] splited = in.readLine().split(" ");
			time[i] = Integer.parseInt(splited[0]);
			money[i] = Integer.parseInt(splited[1]);
		}
		
		for(int i = 1; i <= N; i++) {
			if(i + time[i] <= N + 1) {
				dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + money[i]);
			}
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		
		System.out.println(dp[N + 1]);
	}

}
