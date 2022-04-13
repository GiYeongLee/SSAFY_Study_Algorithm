import java.io.*;
import java.util.*;

public class BJ_9205_맥주마시면서걸어가기 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int TC = Integer.parseInt(in.readLine());
		for(int t = 0; t < TC; t++) {
			input();
			func();
		}
		System.out.println(builder.toString());
	}
	
	static int N;
	static ArrayList<int[]> list;
	static boolean[][] matrix;
	
	static void input() throws NumberFormatException, IOException {
		list = new ArrayList<int[]>();
		N = Integer.parseInt(in.readLine());
		matrix = new boolean[N + 2][N + 2];
		for(int i = 0; i < N + 2; i++) {
			String[] splited = in.readLine().split(" ");
			list.add(new int[] {Integer.parseInt(splited[0]), Integer.parseInt(splited[1])});
		}
	}

	static void func() {
		for(int i = 0; i < N + 2; i++) {
			for(int j = 0; j < N + 2; j++) {
				int[] a = list.get(i);
				int[] b = list.get(j);
				if((Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1])) <= 1000) matrix[i][j] = true;
			}
		}
		
		for(int k = 0; k < N + 2; k++) {
			for(int i = 0; i < N + 2; i++) {
				for(int j = 0; j < N + 2; j++) {
					if(matrix[i][k] & matrix[k][j]) matrix[i][j] = true;
				}
			}
		}
		
		if(matrix[0][N + 1]) builder.append("happy\n");
		else builder.append("sad\n");
	}
}
