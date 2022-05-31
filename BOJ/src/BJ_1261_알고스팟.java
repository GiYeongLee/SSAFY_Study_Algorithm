import java.io.*;
import java.util.*;

public class BJ_1261_알고스팟 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int N, M;
	static int[][] grid, distance;
	
	public static void main(String[] args) throws Exception {
		input();
		func();
		System.out.println(distance[N - 1][M - 1]);
	}
	
	static void input() throws Exception {
		String[] splited = in.readLine().split(" ");
		M = Integer.parseInt(splited[0]);
		N = Integer.parseInt(splited[1]);
		
		grid = new int[N][M];
		distance = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String temp = in.readLine();
			for(int j = 0; j < M; j++) {
				grid[i][j] = temp.charAt(j) - '0';
				distance[i][j] = 9999;
			}
		}	
	}

	static void func() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {0, 0});
		distance[0][0] = 0;
		
		while(!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.poll()[1];
			int curDist = distance[curX][curY];
			
			for(int dir = 0; dir < 4; dir++) {
				int nextX = curX + dx[dir];
				int nextY = curY + dy[dir];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
				
				int nextDist = distance[nextX][nextY];
				
				if(nextDist > curDist + grid[nextX][nextY]) {
					distance[nextX][nextY] = curDist + grid[nextX][nextY];
					queue.add(new int[] {nextX, nextY});
				}		
			}
		}
	}
}

