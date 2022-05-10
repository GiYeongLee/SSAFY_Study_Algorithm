import java.io.*;
import java.util.*;

public class BJ_4179_불 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int R, C;
	static int answer;
	static char[][] grid;
	static Queue<int[]> fire, person;
	
	public static void main(String[] args) throws IOException {
		input();
		func();
	}
	
	static void input() throws IOException {
		fire = new LinkedList<int[]>();
		person = new LinkedList<int[]>();
		answer = 0;
		
		String[] splited = in.readLine().split(" ");
		R = Integer.parseInt(splited[0]);
		C = Integer.parseInt(splited[1]);
		grid = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String input = in.readLine();
			for(int j = 0; j < C; j++) {
				grid[i][j] = input.charAt(j);
				if(grid[i][j] == 'J') person.add(new int[] {i, j});
				else if(grid[i][j] == 'F') fire.add(new int[] {i, j});
			}
		}
	}
	
	static void func() {
		while(true) {
			answer++;
			
			int size = fire.size();
			for(int i = 0; i < size; i++) {
				fireMove(fire.peek()[0], fire.poll()[1]);
			}

			size = person.size();
			for(int i = 0; i < size; i++) {
				personMove(person.peek()[0], person.poll()[1]);
			}
			
			if(person.isEmpty()) {
				System.out.println("IMPOSSIBLE");
				System.exit(0);
			}
		}
	}
	
	static void fireMove(int x, int y) {
		for(int dir = 0; dir < 4; dir++) {
			int nextX = x + dx[dir];
			int nextY = y + dy[dir];
			
			if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
			if(grid[nextX][nextY] == '.') {
				grid[nextX][nextY] = 'F';
				fire.add(new int[] {nextX, nextY});
			}
		}
	}
	
	static void personMove(int x, int y) {
		for(int dir = 0; dir < 4; dir++) {
			int nextX = x + dx[dir];
			int nextY = y + dy[dir];
			
			if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) {
				System.out.println(answer);
				System.exit(0);
			}
			if(grid[nextX][nextY] == '.') {
				grid[nextX][nextY] = 'J';
				person.add(new int[] {nextX, nextY});
			}
		}
	}
}
