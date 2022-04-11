package SW;

import java.io.*;
import java.util.*;

public class SW_1949_등산로조성 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(in.readLine());
		for(int t = 1; t <= TC; t++) {
			input();
			start();
			builder.append("#" + t + " " + answer + "\n");
			answer = Integer.MIN_VALUE;
		}
		System.out.println(builder.toString());
	}
	
	static int N, K, answer;
	static int[][] grid;
	static boolean[][] visited;
	static Queue<int[]> queue;
	
	static void input() throws IOException {
		answer = Integer.MIN_VALUE;
		String[] splited = in.readLine().split(" ");
		N = Integer.parseInt(splited[0]);
		K = Integer.parseInt(splited[1]);
		grid = new int[N][N];
		queue = new LinkedList<int[]>();
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			splited = in.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(splited[j]);
				if(grid[i][j] > max) {
					max = grid[i][j];
					while(!queue.isEmpty()) queue.poll();
					queue.add(new int[] {i, j});
				} else if (grid[i][j] == max) {
					queue.add(new int[] {i, j});
				}
			}
		}
	}

	static void start() {
		while(!queue.isEmpty()) {
			visited = new boolean[N][N];
			int x = queue.peek()[0];
			int y = queue.poll()[1];
			visited[x][y] = true;
			dfs(x, y, 1, true);
		}
	}
	
	static void dfs(int x, int y, int count, boolean chance) {		
		answer = Math.max(answer, count);

		for(int dir = 0; dir < 4; dir++) {
			int nextX = x + dx[dir];
			int nextY = y + dy[dir];
			
			if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
			if(visited[nextX][nextY]) continue;
			
			if(grid[nextX][nextY] >= grid[x][y]) {
				if(chance) {
					for(int i = 1; i <= K; i++) {
						grid[nextX][nextY] -= i;
						if(grid[nextX][nextY] < grid[x][y]) {
							visited[nextX][nextY] = true;
							dfs(nextX, nextY, count + 1, false);
							visited[nextX][nextY] = false;
						}
						grid[nextX][nextY] += i;
					}
				}
				continue;
			} 

			visited[nextX][nextY] = true;
			dfs(nextX, nextY, count + 1, chance);
			visited[nextX][nextY] = false;			
		}
	}
}
