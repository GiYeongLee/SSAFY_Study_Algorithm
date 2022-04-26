import java.io.*;
import java.util.*;

public class BJ_11559_PuyoPuyo {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static char[][] grid = new char[12][6];
	static boolean[][] dfsVisited = new boolean[12][6];
	static boolean[][] bfsVisited = new boolean[12][6];
	static int answer = 0;
	static int count = 0;
	static boolean dfsFlag;
	
	public static void main(String[] args) throws IOException {
		input();
		func();
		System.out.println(answer);
	}
	
	static void input() throws IOException {
		String temp;
		for(int i = 0; i < 12; i++) {
			temp = in.readLine();
			for(int j = 0; j < 6; j++) {
				grid[i][j] = temp.charAt(j);
			}
		}
	}
	
	static void func() {
		while(true) {
			boolean flag = false;
			dfsVisited = new boolean[12][6];
			for(int i = 11; i >= 0; i--) {
				for(int j = 0; j < 5; j++) {
					if(!dfsVisited[i][j] && grid[i][j] != '.') {
						dfsVisited[i][j] = true;
						count = 1;
						if(dfs(i, j, grid[i][j])) {
							bfs(i, j, grid[i][j]);
							flag = true;
						} 
					}
				}
			}
			if(!flag) break;
			answer++;
			
			while(true) if(!down()) break;
		}
	}
	
	static boolean dfs(int curX, int curY, char c) {
		for(int dir = 0; dir < 4; dir++) {
			int nextX = curX + dx[dir];
			int nextY = curY + dy[dir];

			if(nextX < 0 || nextY < 0 || nextX >= 12 || nextY >= 6) continue;
			if(dfsVisited[nextX][nextY] || grid[nextX][nextY] != c) continue;
			dfsVisited[nextX][nextY] = true;
			count++;
			dfs(nextX, nextY, c);
		}
		
		if(count >= 4) return true;
		return false;
	}
	
	static void bfs(int startX, int startY, char c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		bfsVisited = new boolean[12][6];
		queue.add(new int[] {startX, startY});
		bfsVisited[startX][startY] = true;
		grid[startX][startY] = '.';
		
		while(!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.poll()[1];
			
			for(int dir = 0; dir < 4; dir++) {
				int nextX = curX + dx[dir];
				int nextY = curY + dy[dir];
				
				if(nextX < 0 || nextY < 0 || nextX >= 12 || nextY >= 6) continue;
				if(bfsVisited[nextX][nextY] || grid[nextX][nextY] != c) continue;
				
				bfsVisited[nextX][nextY] = true;
				grid[nextX][nextY] = '.';
				queue.add(new int[] {nextX, nextY});
			}
		}
	}
	
	static boolean down() {
		boolean downFlag = false;
		for(int i = 11; i >= 1; i--) {
			for(int j = 0; j < 6; j++) {
				if(grid[i][j] == '.' && grid[i - 1][j] != '.') {
					grid[i][j] = grid[i - 1][j];
					grid[i - 1][j] = '.';
					downFlag = true;
				}
			}
		}
		return downFlag;
	}
	
	static void debug() {
		System.out.println();
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 6; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}

}
