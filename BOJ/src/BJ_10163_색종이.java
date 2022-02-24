import java.io.*;

public class BJ_10163_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());		
		int[][] grid = new int[1001][1001];
		int[] count = new int[N];		
		String[] input = new String[N];
		
		for(int i = 0; i < N; i++) input[i] = in.readLine();
		
		for(int i = N - 1; i >= 0; i--) {
			String[] splited = input[i].split(" ");
			int x = Integer.parseInt(splited[0]);
			int y = Integer.parseInt(splited[1]);
			int l = Integer.parseInt(splited[2]);
			int h = Integer.parseInt(splited[3]);
			for(int j = x; j < x + l; j++) {
				for(int k = y; k < y + h; k++) {
					if(grid[j][k] != 0) continue;					
					grid[j][k]++;
					count[i]++;
				}
			}			
		}		
		for(int i = 0; i < N; i++) builder.append(count[i] + "\n");
		builder.setLength(builder.length() - 1);
		System.out.println(builder);
	}	
}
