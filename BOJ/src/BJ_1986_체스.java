import java.io.*;
import java.util.*;

public class BJ_1986_체스 {
	
	public static class Data{
		int x;
		int y;
		char name;
		
		public Data(int x, int y, char name) {
			super();
			this.x = x;
			this.y = y;
			this.name = name;
		}
	}
	
	static int[] dxQ = {1, 1, -1, -1, 1, 0, -1, 0};
	static int[] dyQ = {-1, 1, 1, -1, 0, -1, 0, 1};
	static int[] dxK = {2, 2, 1, 1, -2, -2, -1, -1};
	static int[] dyK = {1, -1, 2, -2, 1, -1, 2, -2};
	
	static int n, m;
	static char[][] grid;
	static boolean[][] check;
	static Queue<Data> queue = new LinkedList<Data>();

	public static void main(String[] args) throws Exception{
		input();
		set();
		System.out.println(count());
	}
	
	public static void set() {
		while(!queue.isEmpty()) {
			Data cur = queue.poll();	
			switch(cur.name) {
			case 'Q':
				for(int dir = 0; dir < 8; dir++) {
					int curX = cur.x;
					int curY = cur.y;
					while(true) {
						int nextX = curX + dxQ[dir];
						int nextY = curY + dyQ[dir];
						
						if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) break;
						if(grid[nextX][nextY] == 'Q' || grid[nextX][nextY] == 'K' || grid[nextX][nextY] == 'P') break;
						
						check[nextX][nextY] = true;
						curX = nextX;
						curY = nextY;
					}	
				}
				break;
			case 'K':
				int curX = cur.x;
				int curY = cur.y;
				for(int dir = 0; dir < 8; dir++) {
					int nextX = curX + dxK[dir];
					int nextY = curY + dyK[dir];
					
					if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
					if(grid[nextX][nextY] == 'Q' || grid[nextX][nextY] == 'K' || grid[nextX][nextY] == 'P') continue;
					
					check[nextX][nextY] = true;
				}
				break;
			}
		}
	}
	
	public static int count() {
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!check[i][j]) count++;
			}
		}
		return count;
	}
	
	public static void input() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		
		n = Integer.parseInt(splited[0]);
		m = Integer.parseInt(splited[1]);
		
		grid = new char[n][m];
		check = new boolean[n][m];
		
		splited = in.readLine().split(" ");
		int numQ = Integer.parseInt(splited[0]);
		for(int i = 1; i <= numQ * 2; i++) {
			int x = Integer.parseInt(splited[i]) - 1;
			int y = Integer.parseInt(splited[++i]) - 1;			
			grid[x][y] = 'Q';
			check[x][y] = true;
			queue.add(new Data(x, y, 'Q'));
		}
		
		splited = in.readLine().split(" ");
		int numK = Integer.parseInt(splited[0]);
		for(int i = 1; i <= numK * 2; i++) {
			int x = Integer.parseInt(splited[i]) - 1;
			int y = Integer.parseInt(splited[++i]) - 1;			
			grid[x][y] = 'K';
			check[x][y] = true;
			queue.add(new Data(x, y, 'K'));
		}
		
		splited = in.readLine().split(" ");
		int numP = Integer.parseInt(splited[0]);
		for(int i = 1; i <= numP * 2; i++) {
			int x = Integer.parseInt(splited[i]) - 1;
			int y = Integer.parseInt(splited[++i]) - 1;	
			grid[x][y] = 'P';
			check[x][y] = true;
		}
	}

}
