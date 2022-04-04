package SW;

import java.io.*;
import java.util.*;

public class SW_1767_프로세서연결하기 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();
		
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	static int N, coreMax, lengthMin;
	static int[][] grid;
	
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= TC; t++) {		
			input();
			dfs(0, 0, 0);
			builder.append("#" + t + " " + lengthMin + "\n");		
		}

		System.out.println(builder.toString());
	}
	
	public static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(in.readLine());
		grid = new int[N][N];
		list = new ArrayList<int[]>();
		
		for(int i = 0; i < N; i++) {
			String[] splited = in.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(splited[j]);
				if(grid[i][j] == 1) {
					if(i == 0 || j == 0 || i == N - 1 || j == N - 1) {
						continue;
					}
					list.add(new int[] {i, j});
				}
			}
		}	
		coreMax = Integer.MIN_VALUE;
		lengthMin = Integer.MAX_VALUE;
	}
	
	public static void dfs(int count, int length, int index) {	
		if(index == list.size()) {
			if(count > coreMax) {
				coreMax = count;
				lengthMin = length;
			} else if(count == coreMax) {
				if(lengthMin > length) lengthMin = length;
			}
			return;
		}
		
		int curX = list.get(index)[0];
		int curY = list.get(index)[1];

		for(int dir = 0; dir < 4; dir++) {
			
			int move = 0;		
			int nextX = curX;
			int nextY = curY;
			
			while(true) {
				nextX += dx[dir];
				nextY += dy[dir];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) break;
				if(grid[nextX][nextY] == 1) {
					move = 0;
					break;
				}		
				move++;
			}
			
			if(move == 0) {
				dfs(count, length, index + 1);
			} else {
				nextX = curX;
				nextY = curY;
				for(int i = 0; i < move; i++) {
					nextX += dx[dir];
					nextY += dy[dir];
					grid[nextX][nextY] = 1;
				}
				dfs(count + 1, length + move, index + 1);
				
				nextX = curX;
				nextY = curY;
				for(int i = 0; i < move; i++) {
					nextX += dx[dir];
					nextY += dy[dir];
					grid[nextX][nextY] = 0;
				}	
			}	
		}		
	}
}
