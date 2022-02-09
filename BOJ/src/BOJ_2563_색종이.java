import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean[][] grid = new boolean[100][100];	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < TC; t++) {		
			String[] splited = in.readLine().split(" ");
			int x = Integer.parseInt(splited[0]);
			int y = Integer.parseInt(splited[1]);
			for(int i = x; i < x + 10; i++) for(int j = y; j < y + 10; j++) grid[i][j] = true;
		}
		int count = 0;
		for(int i = 0; i < 100; i++) for(int j = 0; j < 100; j++) if(grid[i][j] == true) count++;
		System.out.println(count);
	}
}
