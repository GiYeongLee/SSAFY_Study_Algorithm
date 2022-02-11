import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16926_배열돌리기1 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");	
		int N = Integer.parseInt(splited[0]);
		int M = Integer.parseInt(splited[1]);
		int R = Integer.parseInt(splited[2]);
		int[][] grid = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String[] temp = in.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		int circle = Math.min(N,  M) / 2;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < circle; c++) {
				int temp1 = grid[c][c];
				int curX = c;
				int curY = c;
				int dir = 0;
				
				while(dir < 4) {
					int nextX = curX + dx[dir];
					int nextY = curY + dy[dir];
					if(nextX >= N - c  || nextX < c || nextY >= M - c || nextY < c) {
						dir++;
						continue;
					}
					int temp2 = grid[nextX][nextY];
					grid[nextX][nextY] = temp1;
					temp1 = temp2;
					curX = nextX;
					curY = nextY;
					if(curX == c && curY == c) {
						break;
					}
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}
