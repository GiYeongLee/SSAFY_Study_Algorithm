package SW;

import java.io.*;
import java.util.*;

public class SW_4012_요리사 {
	
	static int N;
	static int[][] grid;
	static boolean[] used;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= TC; t++) {
			
			N = Integer.parseInt(in.readLine());	
			grid = new int[N][N];
			used = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				String[] splited = in.readLine().split(" ");
				for(int j = 0; j < N; j++) grid[i][j] = Integer.parseInt(splited[j]);
			}
			
			min = Integer.MAX_VALUE;
			func(0, 0);
			builder.append("#" + t + " " + min + "\n");
		}
		System.out.println(builder.toString());
	}
	
	public static void func(int cnt, int idx) {
		if(cnt == N / 2) {
			ArrayList<Integer> A = new ArrayList<Integer>();
			ArrayList<Integer> B = new ArrayList<Integer>();
			
			for(int i = 0; i < N; i++) {
				if(used[i] == true) A.add(i);
				else B.add(i);
			}
			
			int sumA = 0;
			int sumB = 0;
			
			for(int i = 0; i < cnt - 1; i++) {
				for(int j = i; j < cnt; j++) {
					sumA = sumA + grid[A.get(i)][A.get(j)] + grid[A.get(j)][A.get(i)];
					sumB = sumB + grid[B.get(i)][B.get(j)] + grid[B.get(j)][B.get(i)];
				}
			}
			
			int temp = Math.abs(sumA - sumB);			
			if(temp < min) min = temp;
			
			return;
		}
		
		for(int i = idx; i < N; i++) {
			used[i] = true;
			func(cnt + 1, i + 1);
			used[i] = false;
		}
		
	}
	
}
