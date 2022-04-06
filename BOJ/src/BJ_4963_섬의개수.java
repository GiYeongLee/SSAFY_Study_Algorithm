import java.io.*;
import java.util.*;

public class BJ_4963_섬의개수 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();
	
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
	static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};
	
	static int w, h;
	static int[][] grid;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		while(input()) {
			builder.append(func() + "\n");
		}
		builder.setLength(builder.length() - 1);
		System.out.println(builder.toString());
	}
	
	static boolean input() throws IOException {
		String[] splited = in.readLine().split(" ");
		w = Integer.parseInt(splited[0]);
		h = Integer.parseInt(splited[1]);
		if(w == 0 && h == 0) {
			return false;
		}
		
		grid = new int[h][w];
		visited = new boolean[h][w];
		for(int i = 0; i < h; i++) {
			splited = in.readLine().split(" ");
			for(int j = 0; j < w; j++) {
				grid[i][j] = Integer.parseInt(splited[j]);
			}
		}
		return true;
	}
	
	static int func() {
		Queue<int[]> queue = new LinkedList<int[]>();
		int count = 0;
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(grid[i][j] == 0 || visited[i][j]) continue;
				
				count++;
				visited[i][j] = true;
				queue.add(new int[] {i, j});
				
				while(!queue.isEmpty()) {
					int curX = queue.peek()[0];
					int curY = queue.poll()[1];
					
					for(int dir = 0; dir < 8; dir++) {
						int nextX = curX + dx[dir];
						int nextY = curY + dy[dir];
						
						if(nextX < 0 || nextY < 0 || nextX >= h || nextY >= w) continue;
						if(visited[nextX][nextY] || grid[nextX][nextY] == 0) continue;
						
						visited[nextX][nextY] = true;
						queue.add(new int[] {nextX, nextY});
					}
				}		
			}
		}	
		return count;
	}
}
