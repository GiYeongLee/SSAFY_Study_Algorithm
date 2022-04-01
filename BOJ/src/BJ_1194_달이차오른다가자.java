import java.io.*;
import java.util.*;

public class BJ_1194_달이차오른다가자 {
	
	static class Person{
		int x;
		int y;
		int count;
		int key;
		
		public Person(int x, int y, int count, int key) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
			this.key = key;
		}
	}

	public static void main(String[] args) throws IOException {
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		
		int N = Integer.parseInt(splited[0]);
		int M = Integer.parseInt(splited[1]);
		
		char[][] grid = new char[N][M];
		boolean[][][] visited = new boolean[N][M][64];
		Queue<Person> queue = new LinkedList<Person>();
		
		for(int i = 0; i < N; i++) {
			String temp = in.readLine();
			for(int j = 0; j < M; j++) {
				grid[i][j] = temp.charAt(j);
				if(grid[i][j] == '0') {
					visited[i][j][0] = true;
					queue.add(new Person(i, j, 0, 0));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Person person = queue.poll();
			
			int curX = person.x;
			int curY = person.y;
			int count = person.count + 1;
			
			for(int dir = 0; dir < 4; dir++) {
				int nextX = curX + dx[dir];
				int nextY = curY + dy[dir];
				
				int key = person.key;
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
				if(grid[nextX][nextY] == '#') continue;
				if(visited[nextX][nextY][key]) continue;
				
				if(grid[nextX][nextY] == '1') {
					System.out.println(count);
					return;
				}
				
				if(grid[nextX][nextY] >= 'a' && grid[nextX][nextY] <= 'f') {
					key = key | 1 << (grid[nextX][nextY] - 'a');
					visited[nextX][nextY][key] = true;
					queue.add(new Person(nextX, nextY, count, key));
					continue;
				}
				
				if(grid[nextX][nextY] >= 'A' && grid[nextX][nextY] <= 'F') {
					if(((1 << (grid[nextX][nextY] - 'A')) & key) == (1 << (grid[nextX][nextY] - 'A'))) {
						visited[nextX][nextY][key] = true;
						queue.add(new Person(nextX, nextY, count, key));
						continue;
					} else {
						continue;
					}
				}
				
				visited[nextX][nextY][key] = true;
				queue.add(new Person(nextX, nextY, count, key));
				
			}
			
		}
		
		System.out.println(-1);
	}
	

}
