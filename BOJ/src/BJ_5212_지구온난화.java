import java.io.*;
import java.util.*;

public class BJ_5212_지구온난화 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int R, C;
	static char[][] grid;
	static Queue<int[]> queue;

	public static void main(String[] args) throws Exception {
		input();
		func();
		System.out.println(builder.toString());
	}

	static void input() throws Exception {
		queue = new LinkedList<int[]>();
		String[] splited = in.readLine().split(" ");
		R = Integer.parseInt(splited[0]);
		C = Integer.parseInt(splited[1]);
		grid = new char[R][C];
		for(int i = 0; i < R; i++) {
			String temp = in.readLine();
			for(int j = 0; j < C; j++) {
				grid[i][j] = temp.charAt(j);
			}
		}
	}
	
	static void func() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(grid[i][j] == 'X') {
					int count = 0;	
					for(int dir = 0; dir < 4; dir++) {
						int nextX = i + dx[dir];
						int nextY = j + dy[dir];
						
						if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) {
							count++;
							continue;
						}
						if(grid[nextX][nextY] == '.') count++;
					}	
					if(count >= 3) queue.add(new int[] {i, j});
				}
			}
		}
		
		while(!queue.isEmpty()) {
			grid[queue.peek()[0]][queue.poll()[1]] = '.';
		}
		
		int minX, minY, maxX, maxY;
		minX = minY = Integer.MAX_VALUE;
		maxX = maxY = Integer.MIN_VALUE;
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(grid[i][j] == 'X') {
					minX = Math.min(minX, i);
					maxX = Math.max(maxX, i);
					minY = Math.min(minY, j);
					maxY = Math.max(maxY, j);
				}
			}
		}
		
		for(int i = minX; i <= maxX; i++) {
			for(int j = minY; j <= maxY; j++) {
				builder.append(grid[i][j]);
			}
			builder.append("\n");
		}
	}
	
}
