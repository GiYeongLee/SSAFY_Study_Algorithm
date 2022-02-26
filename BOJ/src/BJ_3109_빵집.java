import java.io.*;

public class BJ_3109_빵집 {

	static int row, col;
	static char[][] grid;
	static boolean[][] isChecked;
	static int[] dx = {-1, 0, 1};
	static int[] dy = {1, 1, 1};
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		
		row = Integer.parseInt(splited[0]);
		col = Integer.parseInt(splited[1]);
		
		grid = new char[row][col];
		isChecked = new boolean[row][col];
		
		for(int i = 0; i < row; i++) {
			String temp = in.readLine();
			for(int j = 0; j < col; j++) {
				grid[i][j] = temp.charAt(j);
			}
		}
		
		for(int i = 0; i < row; i++) {
			isChecked[i][0] = true;
			func(i, 0);
		}
		
		System.out.println(count);
	}
	
	public static boolean func(int rowNo, int colNo) {
		if(colNo == col - 1) {
			count++;
			return true;
		}
		
		for(int dir = 0; dir < 3; dir++) {
			
			int next_row = rowNo + dx[dir];
			int next_col = colNo + dy[dir];
			
			if(next_row >= row || next_col >= col || next_row < 0 || next_col < 0 || grid[next_row][next_col] == 'x' || isChecked[next_row][next_col] == true) continue;
			
			isChecked[next_row][next_col] = true;
			if(func(next_row, next_col)) return true;
		}
		
		return false;
		
	}
	
}
