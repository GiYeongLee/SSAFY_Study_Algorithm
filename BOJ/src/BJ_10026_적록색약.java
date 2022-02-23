import java.io.*;
import java.util.*;

public class BJ_10026_적록색약 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		char[][] grid = new char[N][N];
		boolean[][] visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String temp = in.readLine();
			for(int j = 0; j < N; j++) {
				grid[i][j] = temp.charAt(j);
			}
		}
		
		Queue<int[]> queue = new LinkedList<int[]>();		
		char RGB = 0;
		
		int count1 = 0;
		int count2 = 0;
		
		while(true) {
			boolean endFlag = true;
			
			loop1:
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(visited[i][j] == false) {
							queue.offer(new int[] {i, j});
							visited[i][j] = true;
							RGB = grid[i][j];
							count1++;
							endFlag = false;
							break loop1;
						}
					}
				}
			
			while(!queue.isEmpty()) {
				int curX = queue.peek()[0];
				int curY = queue.poll()[1];
				
				for(int dir = 0; dir < 4; dir++) {
					int nextX = curX + dx[dir];
					int nextY = curY + dy[dir];
					
					if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
					if(visited[nextX][nextY] == true || grid[nextX][nextY] != RGB) continue;
					
					visited[nextX][nextY] = true;
					queue.offer(new int[] {nextX, nextY});
				}
			}
			
			if(endFlag) break;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(grid[i][j] == 'G') grid[i][j] = 'R';
			}
		}
		
		queue = new LinkedList<int[]>();
		visited = new boolean[N][N];
		visited[0][0] = true;	
		RGB = grid[0][0];
		
		while(true) {
			boolean endFlag = true;
			while(!queue.isEmpty()) {
				int curX = queue.peek()[0];
				int curY = queue.poll()[1];
				
				for(int dir = 0; dir < 4; dir++) {
					int nextX = curX + dx[dir];
					int nextY = curY + dy[dir];
					
					if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
					if(visited[nextX][nextY] == true || grid[nextX][nextY] != RGB) continue;
					
					visited[nextX][nextY] = true;
					queue.offer(new int[] {nextX, nextY});
				}
			}
			
			loop2:
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(visited[i][j] == false) {
						queue.offer(new int[] {i, j});
						visited[i][j] = true;
						RGB = grid[i][j];
						endFlag = false;
						count2++;
						break loop2;
					}
				}
			}
			
			if(endFlag) break;
		}
		
		System.out.println(count1 + " " + count2);
	}

}
