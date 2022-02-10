package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1209_Sum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for(int t = 1; t <= 10; t++) {
			in.readLine();	// 테스트 케이스 번호 읽고 버리기	
			
			int[] sum_j_cross = new int[102];	// 0~99 : 열의 합, 100~101 : 대각선의 합
			int max = 0;	// 최대값
			
			
			for(int i = 0; i < 100; i++) {
				String str = in.readLine();
				int sum_i = 0;	// 행의 합을 저장할 변수
				String[] splited = str.split(" ");
				for(int j = 0; j < 100; j++) {
					int temp = Integer.parseInt(splited[j]);
					sum_i += temp;	// 행의 합을 저장
					sum_j_cross[j] += temp;	// 열의 합을 배열에 저장
					if(i == j) sum_j_cross[100] += temp;	// 좌상우하 대각선의 합을 저장
					if((i + j) == 10) sum_j_cross[101] += temp;	// 우상좌하 대삭선의 합을 저장
				}
				if(sum_i > max) max = sum_i;	// 한 열에 대한 탐색이 끝나면 최대값과 비교
			}
			
			for(int j = 0; j < 102; j++) {	// 열의 합과 대각선의 합이 저장된 배열을 최대값과 비교
				if(sum_j_cross[j] > max) max = sum_j_cross[j];
			}
			
			System.out.println("#" + t + " " + max);
		}
	}

}
