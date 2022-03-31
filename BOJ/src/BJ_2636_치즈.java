import java.io.*;
import java.util.*;

public class BJ_2636_치즈 {

	public static void main(String[] args) throws IOException {
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		
		int M = Integer.parseInt(splited[0]);
		int N = Integer.parseInt(splited[1]);
		
		int[][] grid = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			splited = in.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(splited[j]);
			}
		}
		
		Queue<int[]> queue = new LinkedList<int[]>();
		int answer = 0;	// 치즈가 모두 녹아서 없어지는 데 걸리는 시간
		int last = 0;	// 모두 녹기 한 시간 전에 남아있는 치즈 조각
		
		while(check(grid, M, N)) {
			answer++;
			last = 0;
			
			queue.add(new int[] {0, 0});
			boolean[][] visited = new boolean[M][N];
			
			while(!queue.isEmpty()) {
				int curX = queue.peek()[0];
				int curY = queue.poll()[1];
				
				for(int dir = 0; dir < 4; dir++) {
					int nextX = curX + dx[dir];
					int nextY = curY + dy[dir];
					
					if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
					if(visited[nextX][nextY]) continue;
					
					visited[nextX][nextY] = true;
					
					if(grid[nextX][nextY] == 1) {
						last++;
						grid[nextX][nextY] = 0;
						continue;
					}
					
					queue.add(new int[] {nextX, nextY});
				}
			}
		}
		
		System.out.println(answer);
		System.out.println(last);
	}
	
	public static boolean check(int[][] grid, int M, int N) {
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(grid[i][j] == 1) return true;
			}
		}
		return false;
	}

}
