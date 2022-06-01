import java.io.*;
import java.util.*;

public class BJ_16918_봄버맨 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int R, C, N;
	static char[][] grid;
	
	static Queue<int[]> queue = new LinkedList<int[]>();
	
	public static void main(String[] args) throws Exception {
		input();
		func();
		print();
	}
	
	static void input() throws Exception {
		String[] splited = in.readLine().split(" ");
		R = Integer.parseInt(splited[0]);
		C = Integer.parseInt(splited[1]);
		N = Integer.parseInt(splited[2]);
		
		grid = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String temp = in.readLine();
			for(int j = 0; j < C; j++) {
				grid[i][j] = temp.charAt(j);
				if(grid[i][j] == 'O') queue.add(new int[] {i, j});
			}
		}
	}

	static void func() {
		for(int time = 1; time < N; time++) {
			if(time % 2 == 0) bomb();
			else fill();
		}
	}
	
	static void bomb() {
		while(!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.poll()[1];
			
			grid[curX][curY] = '.';
			
			for(int dir = 0; dir < 4; dir++) {
				int nextX = curX + dx[dir];
				int nextY = curY + dy[dir];
				
				if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
				
				grid[nextX][nextY] = '.';
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(grid[i][j] == 'O') queue.add(new int[] {i, j});
			}
		}
	}
	
	static void fill() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				grid[i][j] = 'O';
			}
		}
	}
	
	static void print() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				builder.append(grid[i][j]);
			}
			builder.append("\n");
		}
		System.out.println(builder.toString());
	}	
}
