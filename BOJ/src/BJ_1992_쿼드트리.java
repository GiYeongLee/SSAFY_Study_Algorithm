
import java.io.*;
import java.util.*;

public class BJ_1992_쿼드트리 {
	
	static int N;
	static int[][] grid;
	static StringBuilder builder = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	
		N = Integer.parseInt(in.readLine());	
		grid = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String temp = in.readLine();
			for(int j = 0; j < N; j++) {
				grid[i][j] = temp.charAt(j) - '0';
			}
		}
		
		func(0, 0, N);
		System.out.println(builder);
	}
	
	public static void func(int x, int y, int length) {
		
		int a = grid[x][y];
		int count = 0;
		
		for(int i = x; i < x + length; i++) {
			for(int j = y; j < y + length; j++) {
				if(grid[i][j] != a) {
					break;
				}
				else count++;
			}
		}
		
		if(count == Math.pow(length, 2)) {
			builder.append(a);
			return;
		}
		
		int temp = length / 2;
		
		builder.append("(");
		
		func(x, y, temp);
		func(x, y + temp, temp);
		func(x + temp, y, temp);
		func(x + temp, y + temp, temp);
		
		builder.append(")");
		
	}
}
