import java.io.*;
import java.util.*;

public class BJ_14502_연구소 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int N, M;
	static int[][] grid;
	
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		input();
		bp(0);
		System.out.println(answer);
	}

	static void input() throws IOException {
		String[] splited = in.readLine().split(" ");
		N = Integer.parseInt(splited[0]);
		M = Integer.parseInt(splited[1]);
		grid = new int[N][M];
		for(int i = 0; i < N; i++) {
			splited = in.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(splited[j]);
			}
		}
	}
	
	static void bp(int count) {
		if(count == 3) {
			bfs();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(grid[i][j] == 0) {
					grid[i][j] = 1;
					bp(count + 1);
					grid[i][j] = 0;
				}
			}
		}
	}
	
	static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();	
		int[][] gridCopy = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				gridCopy[i][j] = grid[i][j];
				if(gridCopy[i][j] == 2) queue.add(new int[] {i, j});
			}
		}
		
		while(!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.poll()[1];
			
			for(int dir = 0; dir < 4; dir++) {
				int nextX = curX + dx[dir];
				int nextY = curY + dy[dir];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
				if(gridCopy[nextX][nextY] == 0) {
					gridCopy[nextX][nextY] = 2;
					queue.add(new int[] {nextX, nextY});
				}
			}
		}	
		count(gridCopy);
	}
	
	static void count(int[][] gridCopy) {
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(gridCopy[i][j] == 0) count++;
			}
		}
		answer = Math.max(answer, count);
	}
}
