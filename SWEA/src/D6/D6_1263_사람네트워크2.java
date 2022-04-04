package D6;

import java.io.*;

public class D6_1263_사람네트워크2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= TC; t++) {
			
			String[] splited = in.readLine().split(" ");
			int N = Integer.parseInt(splited[0]);
			int[][] adjMatrix = new int[N][N];
			
			int idx = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					adjMatrix[i][j] = Integer.parseInt(splited[++idx]);
					if(i != j && adjMatrix[i][j] == 0) {
						adjMatrix[i][j] = 9999999;
					}
				}
			}
			
			for(int k = 0; k < N; k++) {
				for(int i = 0; i < N; i++) {
					if(i == k) continue; // 출발지와 경유지가 같다면 다음 출발지
					for(int j = 0; j < N; j++) {
						if(i == j || k == j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
						if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
							adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
						}
					}
				}
			}
			
			int answer = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				int sum = 0;
				for(int j = 0; j < N; j++) {
					sum += adjMatrix[i][j];
				}
				answer = Math.min(answer, sum);
			}
			
			builder.append("#" + t + " " + answer + "\n");
		}
		System.out.println(builder.toString());
	}
}
