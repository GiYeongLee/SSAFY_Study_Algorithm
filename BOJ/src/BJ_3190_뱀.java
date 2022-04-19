import java.io.*;
import java.util.*;

public class BJ_3190_뱀 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	// 우, 하, 좌, 상
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int N, K, L, dir, time, headX, headY;
	static int[][] grid;
	static Queue<int[]> snake = new LinkedList<int[]>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		func(Integer.MAX_VALUE, 'X');
	}
	
	static void input() throws NumberFormatException, IOException {
		dir = time = headX = headY = 0;
		snake.add(new int[] {0, 0});
		
		N = Integer.parseInt(in.readLine());
		grid = new int[N][N];
		grid[0][0] = 2;
		
		K = Integer.parseInt(in.readLine());
		for(int i = 0; i < K; i++) {
			String[] splited = in.readLine().split(" ");
			int x = Integer.parseInt(splited[0]) - 1;
			int y = Integer.parseInt(splited[1]) - 1;
			grid[x][y] = 1;
		}
		
		L = Integer.parseInt(in.readLine());
		for(int i = 0; i < L; i++) {
			String[] splited = in.readLine().split(" ");
			int t = Integer.parseInt(splited[0]);
			char direction = splited[1].charAt(0);
			func(t, direction);
		}
	}
	
	static void func(int t, char direction) {
		while(time != t) {
			time++;
			int nextX = headX + dx[dir];
			int nextY = headY + dy[dir];
			
			if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || grid[nextX][nextY] == 2) {
				System.out.println(time);
				System.exit(0);
			}
			
			snake.add(new int[] {nextX, nextY});
			headX = nextX;
			headY = nextY;
			
			if(grid[nextX][nextY] != 1) {
				int deleteX = snake.peek()[0];
				int deleteY = snake.poll()[1];
				grid[deleteX][deleteY] = 0;
			} 
			
			grid[nextX][nextY] = 2;
		}
		
		switch(direction) {
		case 'L':
			dir--;
			if(dir == -1) dir = 3;
			break;
		case 'D':
			dir++;
			if(dir == 4) dir = 0;
			break;
		}
	}
}
