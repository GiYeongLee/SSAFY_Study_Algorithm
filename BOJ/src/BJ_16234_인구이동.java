import java.io.*;
import java.util.*;

public class BJ_16234_인구이동 {
	
	public static class Country{
		int x;
		int y;
		
		public Country(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int N, L, R;
	static int[][] grid;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		
		N = Integer.parseInt(splited[0]);
		L = Integer.parseInt(splited[1]);
		R = Integer.parseInt(splited[2]);
		
		grid = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			splited = in.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(splited[j]);
			}
		}
		
		int answer = 0;
		
		while(true) {
			if(func()) {
				break;
			} 
			answer++;
		}
		System.out.println(answer);
	}
	
	public static boolean func() {
		
		boolean flag = true;
		int uniteCount = 0;
		int populationSum = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
				populationSum = 0;
				
				if(!visited[i][j]) {
					
					visited[i][j] = true;
					
					Queue<Country> queue = new LinkedList<Country>();
					ArrayList<Country> unite = new ArrayList<Country>();
					queue.add(new Country(i, j));
					unite.add(new Country(i, j));
					populationSum += grid[i][j];
					
					while(!queue.isEmpty()) {
						
						int curX = queue.peek().x;
						int curY = queue.poll().y;
						
						for(int dir = 0; dir < 4; dir++) {
							int nextX = curX + dx[dir];
							int nextY = curY + dy[dir];
							
							if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
							if(visited[nextX][nextY]) continue;
							
							int diff = Math.abs(grid[curX][curY] - grid[nextX][nextY]);
							if(diff < L || diff > R) continue;
							
							visited[nextX][nextY] = true;
							uniteCount++;
							populationSum += grid[nextX][nextY];
							
							queue.add(new Country(nextX, nextY));
							unite.add(new Country(nextX, nextY));
						}
						
					}
				
					
					if(uniteCount != 0) {	
						flag = false;
						for(Country country : unite) {
							grid[country.x][country.y] = populationSum / unite.size();
						}
					}
				}	
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}
		return flag;
	}

}
