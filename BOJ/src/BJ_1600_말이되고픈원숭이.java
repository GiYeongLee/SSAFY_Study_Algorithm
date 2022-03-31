import java.io.*;
import java.util.*;

public class BJ_1600_말이되고픈원숭이 {
	
	static class Data{
		int x;
		int y;
		int k;	// 말 이동 횟수
		int count;	// 총 이동 횟수
		
		public Data(int x, int y, int k, int count) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.count = count;
		}	
	}
	
	static int[] dx = {1, 0, -1, 0};	// 4방 탐색
	static int[] dy = {0, 1, 0, -1};
	static int[] cdx = {-2, -2, -1, -1, 1, 1, 2, 2};	// 말 이동
	static int[] cdy = {-1, 1, -2, 2, -2, 2, 1, -1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(in.readLine());
		
		String[] splited = in.readLine().split(" ");
		int N = Integer.parseInt(splited[0]);
		int M = Integer.parseInt(splited[1]);
		int[][] grid = new int[M][N];
		boolean[][][] visited = new boolean[M][N][K + 1];
		
		for(int i = 0; i < M; i++) {
			splited = in.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(splited[j]);
			}
		}
		
		Queue<Data> queue = new LinkedList<Data>();
		queue.add(new Data(0, 0, 0, 0));
		visited[0][0][0] = true;	// 방문체크 ( 위치 & 말 이동 횟수 )
		
		while(!queue.isEmpty()) {
			
			Data cur = queue.poll();
			if(cur.x == M - 1 && cur.y == N - 1) {	// 도착
				System.out.println(cur.count);
				return;
			}
			
			for(int dir = 0; dir < 4; dir++) {	// 4방 탐색
				int nextX = cur.x + dx[dir];
				int nextY = cur.y + dy[dir];
				
				if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
				if(visited[nextX][nextY][cur.k] || grid[nextX][nextY] == 1) continue;
				
				visited[nextX][nextY][cur.k] = true;
				queue.add(new Data(nextX, nextY, cur.k, cur.count + 1));
			}
			
			if(cur.k < K) {		// 말 이동 횟수가 남아있을 경우
				for(int dir = 0; dir < 8; dir++) {
					int nextX = cur.x + cdx[dir];
					int nextY = cur.y + cdy[dir];

					if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
					if(visited[nextX][nextY][cur.k + 1] || grid[nextX][nextY] == 1) continue;
					
					visited[nextX][nextY][cur.k + 1] = true;
					queue.add(new Data(nextX, nextY, cur.k + 1, cur.count + 1));
				}
			}	
		}
		System.out.println(-1);	
	}	
}
