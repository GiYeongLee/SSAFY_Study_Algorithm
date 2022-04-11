package D5;

import java.io.*;

public class D5_13433_격자위의가장긴경로 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int direction = 2;
	
	static int N, M, answer;
	static char[][] grid;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int TC = Integer.parseInt(in.readLine());
		for(int t = 1; t <= TC; t++) {
			input();
			boolean[][] visited = new boolean[N][M];
			dfs(0, 0, 1, visited, -1, true);
			builder.append("#" + t + " " + answer + "\n");
		}
		System.out.println(builder.toString());
	}

	static void input() throws IOException {
		answer = Integer.MIN_VALUE;
		String[] splited = in.readLine().split(" ");
		N = Integer.parseInt(splited[0]);
		M = Integer.parseInt(splited[1]);
		grid = new char[N][M];
		for(int i = 0; i < N; i++) {
			String temp = in.readLine();
			for(int j = 0; j < M; j++) {
				grid[i][j] = temp.charAt(j);
			}
		}
	}
	
	static void dfs(int x, int y, int count, boolean[][] visited, int beforeDir, boolean chance) {
		if(x == N - 1 && y == M - 1) {
			answer = Math.max(answer, count);
			return;
		}
		
		for(int dir = 0; dir < 4; dir++) {
			if(dir == beforeDir) continue;
			if(!chance && dir >= 2) break;
			int curX = x;
			int curY = y;
			int nextX, nextY;
			int curCount = count;
			boolean[][] curVisited = copyGrid(visited);
			while(true) {
				nextX = curX + dx[dir];
				nextY = curY + dy[dir];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) break;
				if(grid[nextX][nextY] == '#') break;
				if(curVisited[nextX][nextY]) break;
				
				curCount++;
				curVisited[nextX][nextY] = true;
				
				curX = nextX;
				curY = nextY;
				
				if(dir >= 2) {
					dfs(curX, curY, curCount, curVisited, dir, false);
				} else {
					dfs(curX, curY, curCount, curVisited, dir, true);
				}
			}
			answer = Math.max(answer, count);
		}
		
	}
	
	static boolean[][] copyGrid(boolean[][] visited){
		boolean[][] temp = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				temp[i][j] = visited[i][j];
			}
		}
		return temp;
	}
}
