import java.io.*;
import java.util.*;

public class BJ_2239_스도쿠 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();
	
	static boolean flag = false;
	static int[][] grid = new int[9][9];
	static ArrayList<int[]> unsolved = new ArrayList<int[]>();

	public static void main(String[] args) throws IOException {
		input();
		solve(0);
	}

	static void input() throws IOException {
		for(int i = 0; i < 9; i++) {
			String input = in.readLine();
			for(int j = 0; j < 9; j++) {
				grid[i][j] = input.charAt(j) - '0';
				if(grid[i][j] == 0) unsolved.add(new int[] {i, j});
			}
		}
	}
	
	static void solve(int idx) {
		if(idx == unsolved.size()) {
			print();
			flag = true;
			return;
		}
		
		int[] cur = unsolved.get(idx);
		int x = cur[0];
		int y = cur[1];
		boolean[] check = new boolean[10];
		
		// 가로에 있는 숫자 체크
		for(int i = 0; i < 9; i++) {
			if(grid[x][i] != 0) check[grid[x][i]] = true;
		}
		
		// 세로에 있는 숫자 체크
		for(int i = 0; i < 9; i++) {
			if(grid[i][y] != 0) check[grid[i][y]] = true;
		}
		
		// 3*3 구역에 있는 숫자 체크
		int tempX = (x / 3) * 3;
		int tempY = (y / 3) * 3;
		
		for(int i = tempX; i < tempX + 3; i++) {
			for(int j = tempY; j < tempY + 3; j++) {
				if(grid[i][j] != 0) check[grid[i][j]] = true;
			}
		}
		
		// 체크되어있지 않는 수만 대입
		// 1부터 대입하기 때문에 가장 먼저 완성되는 스도쿠가 사전식으로 맨 앞
		for(int i = 1; i < 10; i++) {
			if(check[i]) continue;
			if(flag) return;
			
			grid[x][y] = i;
			solve(idx + 1);
			grid[x][y] = 0;
		}
	}
	
	static void print() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				builder.append(grid[i][j]);
			}
			builder.append("\n");
		}
		builder.setLength(builder.length() - 1);
		System.out.println(builder.toString());
	}
}
