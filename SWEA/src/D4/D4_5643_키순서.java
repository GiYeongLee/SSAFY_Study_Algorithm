package D4;

import java.io.*;

public class D4_5643_키순서 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();
	
	static int N, M, answer;
	static boolean[][] matrix;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int TC = Integer.parseInt(in.readLine());
		for(int t = 1; t <= TC; t++) {
			input();
			floyd();
			count();
			builder.append("#" + t + " " + answer + "\n");
		}
		builder.setLength(builder.length() - 1);
		System.out.println(builder.toString());
	}
	
	static void input() throws NumberFormatException, IOException {
		answer = 0;
		N = Integer.parseInt(in.readLine());	// 사람 수
		M = Integer.parseInt(in.readLine());	// 비교 횟수
		
		matrix = new boolean[N][N];
		
		for(int i = 0; i < M; i++) {
			String[] splited = in.readLine().split(" ");
			int shorter = Integer.parseInt(splited[0]) - 1;
			int longer = Integer.parseInt(splited[1]) - 1;
			
			matrix[shorter][longer] = true;
		}
	}
	
	static void floyd() {
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(matrix[i][k] && matrix[k][j]) matrix[i][j] = true;
				}
			}
		}
	}
	
	static void count() {
		int[] count = new int[N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(matrix[i][j] || matrix[j][i]) count[i]++;
			}
		}
		
		for(int i : count) {
			if(i == N - 1) answer++;
		}
	}
}
