import java.io.*;

public class BJ_2669_직사각형네개의압집합의면적구하기 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[][] grid = new boolean[100][100];
		
		for(int t = 0; t < 4; t++) {
			String[] splited = in.readLine().split(" ");
			for(int i = Integer.parseInt(splited[0]); i < Integer.parseInt(splited[2]); i++) {
				for(int j = Integer.parseInt(splited[1]); j < Integer.parseInt(splited[3]); j++) {
					grid[i][j] = true;
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(grid[i][j]) count++;
			}
		}
		System.out.println(count);
	}
}
