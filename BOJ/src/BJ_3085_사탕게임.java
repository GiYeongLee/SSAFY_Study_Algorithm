import java.io.*;

public class BJ_3085_사탕게임 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int max = 0;
		
		char[][] grid = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String temp = in.readLine();
			for(int j = 0; j < N; j++) {
				grid[i][j] = temp.charAt(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - 1; j++) {
				char temp = grid[i][j];
				grid[i][j] = grid[i][j + 1];
				grid[i][j + 1] = temp;
				int count = check(grid, N);
				temp = grid[i][j];
				grid[i][j] = grid[i][j + 1];
				grid[i][j + 1] = temp;
				
				if(count > max) max = count;
			}
		}
		
		for(int j = 0; j < N; j++) {
			for(int i = 0; i < N - 1; i++) {
				char temp = grid[i][j];
				grid[i][j] = grid[i + 1][j];
				grid[i + 1][j] = temp;
				int count = check(grid, N);
				temp = grid[i][j];
				grid[i][j] = grid[i + 1][j];
				grid[i + 1][j] = temp;
				
				if(count > max) max = count;
			}
		}
		
		System.out.println(max);
	}
	
	public static int check(char[][] grid, int N) {
		
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			int count = 1;
			char temp = grid[i][0];
			for(int j = 1; j < N; j++) {
				if(grid[i][j] == temp) {
					count++;
					if(max < count) max = count;
				}
				else {
					temp = grid[i][j];
					count = 1;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			int count = 1;
			char temp = grid[0][i];
			for(int j = 1; j < N; j++) {
				if(grid[j][i] == temp) {
					count++;
					if(max < count) max = count;
				}
				else {
					temp = grid[j][i];
					count = 1;
				}
			}
		}
		
		return max;
	}
}
