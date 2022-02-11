import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10157_자리배정 {

	public static void main(String[] args) throws IOException {
		
		int[] dx = {1, 0, 0, -1};
		int[] dy = {0, 1, -1, 0};
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		
		int C = Integer.parseInt(splited[0]);	
		int R = Integer.parseInt(splited[1]);
		
		int[][] grid = new int[C][R];
		
		int K = Integer.parseInt(in.readLine());
		
		int count = 1;
		int x = 0;
		int y = 0;
		int dir = 1;
		grid[x][y] = count;
		
		while(true) {
			if(count == R * C) break;
			
			int curX = x + dx[dir];
			int curY = y + dy[dir];		
			if(curX >= C || curX < 0 || curY >= R || curY < 0 || grid[curX][curY] != 0) {
				dir++;
				if(dir == 4) dir = 0;
				continue;
			}		
			x = curX;
			y = curY;			
			grid[x][y] = ++count;
		}
		
		if(K > R * C) System.out.println(0);
		
		for(int i = 0; i < C; i++) {
			for(int j = 0; j < R; j++) {
				if(grid[i][j] == K) System.out.println((i + 1) + " " + (j + 1));
			}
		}
	}
}
