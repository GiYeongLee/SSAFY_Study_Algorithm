import java.io.*;

public class BJ_17070_파이프옮기기1 {

	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 1, 0};
	
	static int N;
	static int answer = 0;
	static int[][] grid;
	
	public static void main(String[] args) throws IOException {

		input();
		dfs(0, 1, 0);
		System.out.println(answer);

	}
	
	public static void input() throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		grid = new int[N][N];
		for(int i = 0; i < N; i++) {
			String[] splited = in.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(splited[j]);
			}
		}
		
	}
	
	public static void dfs(int x, int y, int beforeDir) {
		
		if(x == N - 1 && y == N - 1) {
			answer++;
			return;
		}
		
		for(int dir = 0; dir < 3; dir++) {
			
			switch(beforeDir) {
			case 0:
				if(dir == 2) continue;
				break;
			case 2:
				if(dir == 0) continue;
				break;
			}
			
			int nextX = x + dx[dir];
			int nextY = y + dy[dir];
			
			if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
			if(grid[nextX][nextY] == 1) continue;
			if(dir == 1 && (grid[nextX - 1][nextY] == 1 || grid[nextX][nextY - 1] == 1)) continue;
			
			dfs(nextX, nextY, dir);
			
		}	
	}
}
