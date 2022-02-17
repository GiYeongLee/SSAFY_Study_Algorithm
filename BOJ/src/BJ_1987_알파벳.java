import java.io.*;

public class BJ_1987_알파벳 {
	
	static int R, C;
	static char[][] grid;
	static boolean[] visited = new boolean[26];
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		
		R = Integer.parseInt(splited[0]);
		C = Integer.parseInt(splited[1]);
		grid = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String str = in.readLine();
			for(int j = 0; j < C; j++) {
				grid[i][j] = str.charAt(j);
			}
		}
		
		visited[grid[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		
		System.out.println(max);
	}
	
	public static void dfs(int x, int y, int count) {
		
		
		for(int dir = 0; dir < 4; dir++) {
			
			int nextX = x + dx[dir];
			int nextY = y + dy[dir];
			
			if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
			if(visited[grid[nextX][nextY] - 'A'] == true) continue;
			
			visited[grid[nextX][nextY] - 'A'] = true;
			dfs(nextX, nextY, count + 1);
			visited[grid[nextX][nextY] - 'A'] = false;
			
		}
		
		if(count > max) max = count;
	}
}
