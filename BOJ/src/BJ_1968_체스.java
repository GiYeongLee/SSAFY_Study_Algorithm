import java.io.*;
import java.util.*;

public class BJ_1968_체스 {

	public static void main(String[] args) throws Exception{
		
		// setting
		int[] dxQ = {1, 1, -1, -1};
		int[] dyQ = {-1, 1, 1, -1};
		int[] dxK = {2, 2, 1, 1, -2, -2, -1, -1};
		int[] dyK = {1, -1, 2, -2, 1, -1, 2, -2};

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		
		int n = Integer.parseInt(splited[0]);
		int m = Integer.parseInt(splited[1]);
		
		int[][] grid = new int[n][m];
		
		splited = in.readLine().split(" ");
		
		int numQ = Integer.parseInt(splited[0]);
		
		for(int i = 1; i <= numQ; i++) {
			int x = Integer.parseInt(splited[i]);
			int y = Integer.parseInt(splited[i + 1]);
			
			grid[x][y] = 1;
			
			for(int dir = 0; dir < 4; dir++) {
				int curX = x;
				int curY = y;
				while(true) {
					int nextX = x + dxQ[dir];
					int nextY = y + dyQ[dir];
				}
			}
		}

	}

}
