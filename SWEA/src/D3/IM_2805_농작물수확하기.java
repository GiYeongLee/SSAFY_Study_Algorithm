package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IM_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());

		for(int t = 1; t <= TC; t++) {
			
			int N = Integer.parseInt(in.readLine());
			int[][] grid = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String temp = in.readLine();
				for(int j = 0; j < N; j++) {
					grid[i][j] = temp.charAt(j) - '0';
				}
			}
			
			int init = N / 2;
			int sum = 0;
			
			for(int i = 0; i < N; i++) {
				sum += grid[i][N / 2];

			}

			for(int j = 1; j <= (N / 2); j++) {
				for(int i = j; i < N - j; i++) {
					sum += grid[i][init + j];
					sum += grid[i][init - j];
				}
			}		
			System.out.println("#" + t + " " + sum);	
		}
	}
}
