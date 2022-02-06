package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_1954_달팽이숫자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(in.readLine());
		
		int[] dx = {1, 0, 0, -1};
		int[] dy = {0, 1, -1, 0};
		
		for(int T = 1; T <= tc; T++) {
			
			int N = Integer.parseInt(in.readLine());
			
			int[][] grid = new int[N][N];
			int count = 1;
			int x = 0;
			int y = 0;
			int dir = 1;
			grid[x][y] = 1;
			
			while(true) {
				if(count == N * N) {
					break;
				}
				int curX = x + dx[dir];
				int curY = y + dy[dir];		
				if(curX >= N || curX < 0 || curY >= N || curY < 0 || grid[curX][curY] != 0) {
					dir++;
					if(dir == 4) {
						dir = 0;
					}
					continue;
				}		
				x = curX;
				y = curY;			
				grid[x][y] = ++count;
			}
			System.out.println("#" + T);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(grid[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
