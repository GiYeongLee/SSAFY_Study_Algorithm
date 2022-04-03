import java.io.*;
import java.util.*;

public class BJ_13565_침투 {
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int M, N;
	static int[][] grid;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {	
		input();
		if(bfs()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
	public static void input() throws IOException {		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		M = Integer.parseInt(splited[0]);
		N = Integer.parseInt(splited[1]);
		grid = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i = 0; i < M; i++) {
			String input = in.readLine();
			for(int j = 0; j < N; j++) {
				grid[i][j] = input.charAt(j) - '0';
			}
		}	
	}
	
	public static boolean bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for(int i = 0; i < N; i++) {
			if(grid[0][i] == 0) {
				queue.add(new int[] {0, i});
				visited[0][i] = true;
				
				while(!queue.isEmpty()) {				
					int curX = queue.peek()[0];
					int curY = queue.poll()[1];	
					
					if(curX == M - 1) return true;
					
					for(int dir = 0; dir < 4; dir++) {
						int nextX = curX + dx[dir];
						int nextY = curY + dy[dir];
						
						if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
						if(grid[nextX][nextY] == 1 || visited[nextX][nextY]) continue;
						
						visited[nextX][nextY] = true;
						queue.add(new int[] {nextX, nextY});
					}				
				}
			}
		}	
		return false;
	}
}
