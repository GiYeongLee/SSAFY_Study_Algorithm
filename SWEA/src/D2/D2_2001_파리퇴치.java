package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_2001_파리퇴치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	
		int TC = Integer.parseInt(in.readLine());

		for(int t = 1; t <= TC; t++) {
			
			String temp = in.readLine();
			String[] splited = temp.split(" ");
			int N = Integer.parseInt(splited[0]);
			int M = Integer.parseInt(splited[1]);
			
			int[][] arr = new int[N][N];
			int sum = 0;
			
			for(int i = 0; i < N; i++) {
				temp = in.readLine();
				String[] splited2 = temp.split(" ");
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(splited2[j]);
				}
			}		
			for(int i = 0; i < N - M + 1; i++) {
				for(int j = 0; j < N - M + 1; j++) {
					int temp2 = 0;
					for(int x = 0; x < M; x++) {
						for(int y = 0; y < M; y++) {
							temp2 += arr[i + x][j + y];
						}
					}
					if(temp2 > sum) sum = temp2;	
				}
			}		
			System.out.println("#" + t + " " + sum);
		}
	}
}
