package SW;

import java.io.*;

public class SW_5644_무선충전 {
	public static void main(String[] args) throws IOException {
		
		int[] dx = {0, 0, 1, 0, -1};
		int[] dy = {0, -1, 0, 1, 0};
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder builder = new StringBuilder();
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= TC; t++) {
			
			String[] splited = in.readLine().split(" ");
			int M = Integer.parseInt(splited[0]);
			int A = Integer.parseInt(splited[1]);
			
			String[] arrA = in.readLine().split(" ");	// A의 이동경로
			String[] arrB = in.readLine().split(" ");	// B의 이동경로
			
			int[][] AP = new int[A][4];
			
			for(int i = 0; i < A; i++) {
				splited = in.readLine().split(" ");
				AP[i][0] = Integer.parseInt(splited[0]);	// AP x좌표
				AP[i][1] = Integer.parseInt(splited[1]);	// AP y좌표
				AP[i][2] = Integer.parseInt(splited[2]);	// AP 범위
				AP[i][3] = Integer.parseInt(splited[3]);	// AP 성능
			}
			
			int count = 0;
			
			int[] locA = {1, 1};	// 사람 A의 시작 위치
			int[] locB = {10, 10};	// 사람 B의 시작 위치
			
			int[] tempA = new int[A];
			int[] tempB = new int[A];
			
			for(int j = 0; j < A; j++) {
				int distanceA = Math.abs(AP[j][0] - locA[0]) + Math.abs(AP[j][1] - locA[1]);
				int distanceB = Math.abs(AP[j][0] - locB[0]) + Math.abs(AP[j][1] - locB[1]);
				
				if(distanceA <= AP[j][2]) tempA[j] = AP[j][3];
				if(distanceB <= AP[j][2]) tempB[j] = AP[j][3];
			}
			
			int max = 0;
			
			for(int j = 0; j < A; j++) {
				for(int k = 0; k < A; k++) {
					int temp = tempA[j] + tempB[k];
					if(temp > max) max = temp;
				}
			}
			count += max;
			
			for(int i = 0; i < M; i++) {
				
				int commandA = Integer.parseInt(arrA[i]);
				int commandB = Integer.parseInt(arrB[i]);
				
				locA[0] = locA[0] + dx[commandA];
				locA[1] = locA[1] + dy[commandA];
				locB[0] = locB[0] + dx[commandB];
				locB[1] = locB[1] + dy[commandB];
				
				tempA = new int[A];
				tempB = new int[A];
				
				for(int j = 0; j < A; j++) {
					int distanceA = Math.abs(AP[j][0] - locA[0]) + Math.abs(AP[j][1] - locA[1]);
					int distanceB = Math.abs(AP[j][0] - locB[0]) + Math.abs(AP[j][1] - locB[1]);
					
					if(distanceA <= AP[j][2]) tempA[j] = AP[j][3];
					if(distanceB <= AP[j][2]) tempB[j] = AP[j][3];
				}
				
				max = 0;
				
				for(int j = 0; j < A; j++) {
					for(int k = 0; k < A; k++) {
						int temp = tempA[j] + tempB[k];
						if(tempA[j] == tempB[k] && j == k) temp /= 2;
						if(temp > max) max = temp;
					}
				}
				count += max;
			}
			builder.append("#" + t + " " + count + "\n");
		}
		System.out.println(builder.toString());
	}
}
