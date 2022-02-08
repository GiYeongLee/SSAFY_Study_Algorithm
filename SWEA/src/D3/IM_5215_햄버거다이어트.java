package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IM_5215_햄버거다이어트 {
	
	static int N, L;
	static int[] taste;
	static int[] cal;
	static int max;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= TC; t++) {
			
			String[] splited = in.readLine().split(" ");
			N = Integer.parseInt(splited[0]);
			L = Integer.parseInt(splited[1]);
			
			taste = new int[N];
			cal = new int[N];
			
			for(int i = 0; i < N; i++) {
				String[] splited2 = in.readLine().split(" ");
				taste[i] = Integer.parseInt(splited2[0]);
				cal[i] = Integer.parseInt(splited2[1]);
			}
			
			max = 0;
			combination(0, 0, 0);
			
			System.out.println("#" + t + " " + max);
		}
	}

	public static void combination(int cnt, int sumTaste, int sumCal) {	
		if(sumCal > L) {
			return;
		}
		
		if(cnt == N) {
			max = Math.max(max, sumTaste);
			return;
		}
		
		combination(cnt + 1, sumTaste + taste[cnt], sumCal + cal[cnt]);
		combination(cnt + 1, sumTaste, sumCal);
	}
}
