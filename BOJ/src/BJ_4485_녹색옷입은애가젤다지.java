import java.io.*;
import java.util.*;

public class BJ_4485_녹색옷입은애가젤다지 {
	public static class Data implements Comparable<Data>{
		int x;
		int y;
		int weight;
		
		public Data(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int TC = 1;
		
		while(true) {
			int N = Integer.parseInt(in.readLine());
			if(N == 0) break;
			
			int[][] grid = new int[N][N];
			int[][] distance = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String[] splited = in.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(splited[j]);
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
			
			PriorityQueue<Data> pq = new PriorityQueue<Data>();		
			pq.add(new Data(0, 0, grid[0][0]));
			
			distance[0][0] = grid[0][0];
			
			while(!pq.isEmpty()) {		
				for(int dir = 0; dir < 4; dir++) {
					int nextX = pq.peek().x + dx[dir];
					int nextY = pq.peek().y + dy[dir];
					
					if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
					
					if(distance[pq.peek().x][pq.peek().y] + grid[nextX][nextY] < distance[nextX][nextY]) {
						distance[nextX][nextY] = distance[pq.peek().x][pq.peek().y] + grid[nextX][nextY];
						pq.add(new Data(nextX, nextY, distance[nextX][nextY]));
					}
				}
				pq.poll();
			}
			builder.append("Problem " + TC + ": " + distance[N - 1][N - 1] + "\n");
			TC++;
		}
		System.out.println(builder.toString());
	}
	
}
