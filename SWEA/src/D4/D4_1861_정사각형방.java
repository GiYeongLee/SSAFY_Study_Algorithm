package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class D4_1861_정사각형방 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	
		int TC = Integer.parseInt(in.readLine());		
		int[] dx = {1, 0, 0, -1};
		int[] dy = {0, 1, -1, 0};
		
		for(int t = 1; t <= TC; t++) {
			
			int N = Integer.parseInt(in.readLine());
			int roomNum = 0;
			int roomCntMax = 0;
			int[][] room = new int[N][N];
			Queue<int[]> queue = new LinkedList<int[]>();
			
			for(int i = 0; i < N; i++) {
				String[] splited = in.readLine().split(" ");
				for(int j = 0; j < N; j++) room[i][j] = Integer.parseInt(splited[j]);
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					queue.offer(new int[] {i, j});
					int count = 0;
					while(!queue.isEmpty()) {
						int[] cur = queue.poll();
						for(int dir = 0; dir < 4; dir++) {
							int cur_x = cur[0] + dx[dir];
							int cur_y = cur[1] + dy[dir];	
							if(cur_x < 0 || cur_y < 0 || cur_x >= N || cur_y >= N) continue;
							if(room[cur_x][cur_y] != room[cur[0]][cur[1]] + 1) continue;
							queue.offer(new int[] {cur_x, cur_y});		
							count++;
						}
					}
					if(count > roomCntMax) {
						roomNum = room[i][j];
						roomCntMax = count;
					}
					else if(count == roomCntMax) if(room[i][j] < roomNum) roomNum = room[i][j];
				}
			}
			System.out.println("#" + t + " " + roomNum + " " + (roomCntMax + 1));
		}
	}
}
