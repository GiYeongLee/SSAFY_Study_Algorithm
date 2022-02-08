import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2578_빙고 {
	static int[][] grid = new int[5][5];
	static int count = 0;
	static int[] check = new int[12];

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 5; i++) {
			String[] splited = in.readLine().split(" ");
			for(int j = 0; j < 5; j++) {
				grid[i][j] = Integer.parseInt(splited[j]);
			}
		}
		
		int ans = 0;
		for(int i = 0; i < 5; i++) {
			String[] splited = in.readLine().split(" ");
			for(int j = 0; j < 5; j++) {
				ans++;
				bingoAdd(Integer.parseInt(splited[j]));
				bingoCheck();
				if(count >= 3) {
					System.out.println(ans);
					return;
				}
			}
		}
	}

	static void bingoCheck() {
		if(grid[0][0] == 0) {
			int flag = 0;
			for(int i = 1; i <= 4; i++) {
				if(grid[i][i] == 0) flag++;
				else break;
			}
			if(flag == 4) {
				if(check[10] == 0) {
					check[10] = 1;
					count++;
				}
			}
		}
		if(grid[0][4] == 0) {
			int flag = 0;
			int x = 1;
			for(int i = 3; i >= 0; i--) {
				if(grid[x++][i] == 0) flag++;
				else break;
			}
			if(flag == 4) {
				if(check[11] == 0) {
					check[11] = 1;
					count++;
				}
			}
		}
		
		for(int i = 0; i < 5; i++) {
			if(grid[i][0] == 0) {
				int flag = 0;
				for(int j = 1; j <= 4; j++) {
					if(grid[i][j] == 0) flag++;
					else break;
				}
				if(flag == 4) {
					if(check[i] == 0) {
						check[i] = 1;
						count++;
					}
				}
			}
			if(grid[0][i] == 0) {
				int flag = 0;
				for(int j = 1; j <= 4; j++) {
					if(grid[j][i] == 0) flag++;
					else break;
				}
				if(flag == 4) {
					if(check[i + 5] == 0) {
						check[i + 5] = 1;
						count++;
					}
				}
			}
		}
	}
	
	static void bingoAdd(int num) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(grid[i][j] == num) grid[i][j] = 0;
			}
		}
	}
}
