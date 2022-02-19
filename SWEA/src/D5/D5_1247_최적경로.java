package D5;

import java.io.*;
import java.util.*;

public class D5_1247_최적경로 {
	
	static int N;
	static int[] company;
	static int[] home;
	static int[][] guest;
	static boolean[] isSelected;
	static int[] route;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= TC; t++) {
			
			N = Integer.parseInt(in.readLine());
			
			company = new int[2];
			home = new int[2];
			guest = new int[N][2];
			isSelected = new boolean[N];
			route = new int[N];
			min = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());

			for(int i = 0; i < N; i++) {
				guest[i][0] = Integer.parseInt(st.nextToken());
				guest[i][1] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0);
			
			builder.append("#" + t + " " + min + "\n");
		}
		System.out.println(builder);
	}
	
	static void permutation(int cnt) {
		if(cnt == N) {
			int dist = 0;
			
			dist += calc(company[0], company[1], guest[route[0]][0], guest[route[0]][1]);	
			
			for(int i = 0; i < N - 1; i++) {
				dist += calc(guest[route[i]][0], guest[route[i]][1], guest[route[i + 1]][0], guest[route[i + 1]][1]);	
				if(dist > min) break;
			}
			
			dist += calc(guest[route[N - 1]][0], guest[route[N - 1]][1], home[0], home[1]);
			
			if(dist < min) min = dist;
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isSelected[i] == true) continue;
			isSelected[i] = true;
			route[cnt] = i;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	}
	
	static int calc(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
