package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IM_9229_한빈이와SpotMart {
	
	static int[] weight;
	static int[] ans;
	static int N;
	static int M;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= TC; t++) {
			
			String[] splited = in.readLine().split(" ");
			N = Integer.parseInt(splited[0]);
			M = Integer.parseInt(splited[1]);	
			weight = new int[N];
			ans = new int[2];
			
			String[] splited2 = in.readLine().split(" ");
			
			for(int i = 0; i < N; i++) weight[i] = Integer.parseInt(splited2[i]);
			
			max = 0;
			func(0, 0, 0);
			if(max == 0) System.out.println("#" + t + " " + -1);
			else System.out.println("#" + t + " " + max);
		}	
	}
	
	static void func(int cnt, int start, int sum) {
		if(cnt == 2) {
			if(sum > max) max = sum;
			return;
		}		
		for(int i = start; i < N; i++) {
			if(sum + weight[i] > M) continue;
			ans[cnt] = weight[i];
			func(cnt + 1, i + 1, sum + weight[i]);
		}
	}
}
