import java.io.*;
import java.util.*;

public class BJ_2583_영역구하기 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int M, N, K;
	static boolean[][] grid;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		input();
		System.out.println(builder.toString());
	}
	
	static void input() throws Exception{
		String[] splited = in.readLine().split(" ");
		M = Integer.parseInt(splited[0]);
		N = Integer.parseInt(splited[1]);
		K = Integer.parseInt(splited[2]);
		grid = new boolean[M][N];
		visited = new boolean[M][N];
		
		for(int i = 0; i < K; i++) {
			splited = in.readLine().split(" ");
			
			for(int r = Integer.parseInt(splited[1]); r < Integer.parseInt(splited[3]); r++) {
				for(int c = Integer.parseInt(splited[0]); c < Integer.parseInt(splited[2]); c++) {
					grid[r][c] = true;
				}
			}
		}
		
		func();	
	}
	
	static void func() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int count = 0;
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(grid[i][j] || visited[i][j]) continue;		
				count++;
				pq.add(bfs(i, j));
			}
		}
		builder.append(count + "\n");
		while(!pq.isEmpty()) builder.append(pq.poll() + " ");
	}
	
	static int bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {i, j});
		visited[i][j] = true;
		int count = 1;
		
		while(!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.poll()[1];
			
			for(int dir = 0; dir < 4; dir++) {
				int nextX = curX + dx[dir];
				int nextY = curY + dy[dir];
				
				if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
				if(grid[nextX][nextY] || visited[nextX][nextY]) continue;
				
				count++;
				visited[nextX][nextY] = true;
				queue.add(new int[] {nextX, nextY});
			}
		}	
		return count;
	}
}
