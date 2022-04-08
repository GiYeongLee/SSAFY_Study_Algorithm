package SW;

import java.io.*;
import java.util.*;

public class SW_1953_탈주범검거 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();
	
	// 4방탐색용 배열
	// 위, 아래, 오른쪽, 왼쪽
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	// 연결 확인용 배열
	static boolean[][] direction = {
			// 위, 아래, 오른쪽, 왼쪽
			{false, false, false, false},
			{true, true, true, true},
			{true, true, false, false},
			{false, false, true, true},
			{true, false, true, false},
			{false, true, true, false},
			{false, true, false, true},
			{true, false, false, true}
	};
	
	static int N, M, R, C, L, answer;
	static int[][] grid;
	static boolean[][] visited;	
	static Queue<int[]> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int TC = Integer.parseInt(in.readLine());
		for(int t = 1; t <= TC; t++) {
			input();
			bfs();
			builder.append("#" + t + " " + answer + "\n");
		}
		builder.setLength(builder.length() - 1);
		System.out.println(builder.toString());
	}

	static void input() throws IOException {
		String[] splited = in.readLine().split(" ");
		N = Integer.parseInt(splited[0]);
		M = Integer.parseInt(splited[1]);
		grid = new int[N][M];
		visited = new boolean[N][M];
		R = Integer.parseInt(splited[2]);
		C = Integer.parseInt(splited[3]);
		L = Integer.parseInt(splited[4]);
		
		for(int i = 0; i < N; i++) {
			splited = in.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(splited[j]);
			}
		}
		
		answer = 1;
		queue = new LinkedList<int[]>();
		queue.clear();
	}
	
	// BFS
	static void bfs() {
		queue.add(new int[] {R, C, 1});
		visited[R][C] = true;
		
		int curX, curY, count;
		while(!queue.isEmpty()) {
			curX = queue.peek()[0];
			curY = queue.peek()[1];
			count = queue.poll()[2];
			if(count >= L) continue;
			
			for(int dir = 0; dir < 4; dir++) {
				int nextX = curX + dx[dir];
				int nextY = curY + dy[dir];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
				if(visited[nextX][nextY] || grid[nextX][nextY] == 0) continue;
				if(!check(grid[curX][curY], grid[nextX][nextY], dir)) continue;
				
				answer++;
				visited[nextX][nextY] = true;
				queue.add(new int[] {nextX, nextY, count + 1});
			}
		}
	}
	
	// 연결 확인
	static boolean check(int cur, int next, int dir) {
		switch(dir) {
		case 0:
			return direction[cur][0] && direction[next][1];
		case 1:
			return direction[cur][1] && direction[next][0];
		case 2:
			return direction[cur][2] && direction[next][3];
		case 3:
			return direction[cur][3] && direction[next][2];
		}
		return false;
	}
}
