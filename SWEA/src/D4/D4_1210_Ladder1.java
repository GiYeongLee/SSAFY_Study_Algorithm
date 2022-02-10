package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class D4_1210_Ladder1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		int[] dx = {1, 0, 0};
		int[] dy = {0, 1, -1};
		
		for(int t = 1; t <= 10; t++) {
			int[][] grid = new int[100][100];
			in.readLine();
			for(int i = 0; i < 100; i++) {
				String[] splited = in.readLine().split(" ");
				for(int j = 0; j < 100; j++) grid[i][j] = Integer.parseInt(splited[j]);
			}
			int flag = 0;
			int i = 0;
			int ans = 0;
			for(int j = 0; j < 100; j++) {
				if(flag == 1) break;
				if(grid[i][j] == 1) {
					int[][] vis = new int[100][100];
					Queue<int[]> queue = new LinkedList<int[]>();	
					queue.offer(new int[] {i, j});
					
					while(!queue.isEmpty()) {
						int flag2 = 0;
						int[] cur = queue.poll();
						for(int dir = 1; dir <= 2; dir++) {
							int cur_x = cur[0] + dx[dir];
							int cur_y = cur[1] + dy[dir];	
							if(cur_y < 0 || cur_y >= 100) continue;
							if(grid[cur_x][cur_y] != 1 || vis[cur_x][cur_y] == 1) continue;
							vis[cur[0]][cur[1]] = 1;
							queue.offer(new int[] {cur_x, cur_y});	
							flag2 = 1;
						}
						int cur_x = cur[0] + dx[0];
						int cur_y = cur[1] + dy[0];
						
						if(cur_x >= 100) continue;
						
						if(grid[cur_x][cur_y] == 2) {
							flag = 1;
							ans = j;
							break;
						}

						if(flag2 == 0) {
							vis[cur[0]][cur[1]] = 1;
							queue.offer(new int[] {cur_x, cur_y});
							continue;
						}
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
