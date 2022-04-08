import java.io.*;
import java.util.*;

public class BJ_17135_캐슬디펜스 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, M, D;
	static int[][] grid;
	static int[] loc = new int[3];
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		input();
		combination(0, 0);
		System.out.println(answer);
	}
	
	static void input() throws IOException {
		String[] splited = in.readLine().split(" ");
		N = Integer.parseInt(splited[0]);
		M = Integer.parseInt(splited[1]);
		D = Integer.parseInt(splited[2]);
		grid = new int[N][M];
		for(int i = 0; i < N; i++) {
			splited = in.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(splited[j]);
			}
		}
	}
	
	static void combination(int count, int start) {
		if(count == 3) {
			simulation();
			return;
		}		
		for(int i = start; i < M; i++) {
			loc[count] = i;
			combination(count + 1, i + 1);
		}
	}

	static void simulation() {
		int[][] copyGrid = copyGrid(grid);
		Queue<int[]> queue = new LinkedList<int[]>();		
		int count = 0;
		int time = 0;
		
		while(time < N) {			
			for(int n = 0; n < 3; n++) {
				int archerX = N - time;
				int archerY = loc[n];
				
				int minDist = Integer.MAX_VALUE;
				int minX = Integer.MAX_VALUE;
				int minY = Integer.MAX_VALUE;
				
				for(int i = archerX - 1; i >= 0; i--) {
					for(int j = 0; j < M; j++) {
						if(copyGrid[i][j] == 1) {
							int curDist = calculate(archerX, archerY, i, j);
							if(curDist <= D) {
								if(curDist < minDist) {
									minDist = curDist;
									minX = i;
									minY = j;
								}
								if(curDist == minDist) {
									if(j < minY) {
										minX = i;
										minY = j;
									}
								}
							}
						}
					}
				}			
				if(minX == Integer.MAX_VALUE) continue;
				
				queue.add(new int[] {minX, minY});
			}

			while(!queue.isEmpty()) {
				int x = queue.peek()[0];
				int y = queue.poll()[1];
				if(copyGrid[x][y] == 1) {	// 같은 적을 때릴지도...
					copyGrid[x][y] = 0;
					count++;
				}
			}		
			time++;
		}		
		answer = Math.max(answer, count);
	}
	
	static int[][] copyGrid(int[][] grid){
		int[][] copyGrid = new int[N + 1][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copyGrid[i][j] = grid[i][j];
			}
		}
		return copyGrid;
	}
	
	static int calculate(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
