package D4;

import java.io.*;
import java.util.*;

public class D4_1249_보급로 {
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int minCost;
		
		public Node(int x, int y, int minCost) {
			super();
			this.x = x;
			this.y = y;
			this.minCost = minCost;
		}

		@Override
		public int compareTo(Node o) {
			return this.minCost - o.minCost;
		}
	}
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int N;
	static int[][] grid;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int TC = Integer.parseInt(in.readLine());
		for(int t = 1; t <= TC; t++) {
			input();
			builder.append("#" + t + " " + dijkstra(0, 0) + "\n");
		}
		System.out.println(builder.toString());
	}

	static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(in.readLine());
		grid = new int[N][N];
		for(int i = 0; i < N; i++) {
			String input = in.readLine();
			for(int j = 0; j < N; j++) {
				grid[i][j] = input.charAt(j) - '0';
			}
		}
	}
	
	static int dijkstra(int x, int y) {
		boolean[][] visited = new boolean[N][N];
		int[][] minTime = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				minTime[i][j] = 9999;
			}
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		minTime[x][y] = 0;
		pq.offer(new Node(x, y, 0));
		
		int curX, curY, minCost, nextX, nextY;
		Node current;
		
		while(true) {
			current = pq.poll();
			curX = current.x;
			curY = current.y;
			minCost = current.minCost;
			
			if(visited[curX][curY]) continue;		
			visited[curX][curY] = true;
			
			if(curX == N - 1 && curY == N - 1) return minCost;	// 도착
			
			for(int dir = 0; dir < 4; dir++) {
				nextX = curX + dx[dir];
				nextY = curY + dy[dir];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
				if(minTime[nextX][nextY] <= minCost + grid[nextX][nextY]) continue;
				
				minTime[nextX][nextY] = minCost + grid[nextX][nextY];
				
				pq.offer(new Node(nextX, nextY, minTime[nextX][nextY]));
			}
		}
	}
}
