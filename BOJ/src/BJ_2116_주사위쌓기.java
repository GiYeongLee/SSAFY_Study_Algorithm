import java.io.*;
import java.util.*;


public class BJ_2116_주사위쌓기 {
	

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());	// 주사위의 개수
		int[][] dice = new int[N][6];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			dice[i][0] = Integer.parseInt(st.nextToken());	// i + 3 은 주사위의 반대편
			dice[i][1] = Integer.parseInt(st.nextToken());
			dice[i][2] = Integer.parseInt(st.nextToken());
			dice[i][4] = Integer.parseInt(st.nextToken());
			dice[i][5] = Integer.parseInt(st.nextToken());
			dice[i][3] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		
		for(int k = 0; k < 6; k++) {
			int sum = 0;
			int select = dice[0][k];	// 아랫면 선택
			sum += findMax(dice[0], select, k);	// 아랫면, 윗면을 제외한 최대값을 sum에 덧셈
			
			for(int i = 1; i < N; i++) {	// 주사위의 개수만큼
				for(int j = 0; j < 6; j++) {
					if(dice[i][j] == select) {	// 주사위 중 select와 같은 값을 찾기
						sum += findMax(dice[i], select, j);	// 아랫면, 윗면을 제외한 최대값을 sum에 덧셈
						if(j < 3) select = dice[i][j + 3];	// 윗면을 select에 저장
						else select = dice[i][j - 3];
						break;
					}
				}
			}	
			if(sum > max) max = sum;
		}
		System.out.println(max);
	}
	
	public static int findMax(int[] dice, int select, int idx) {
		
		int[] diceTemp = dice.clone();	// 입력으로 들어온 dice 복제

		diceTemp[idx] = 0;	// 복제된 배열에서 아랫면을 0으로
		if(idx < 3) diceTemp[idx + 3] = 0;	// 복제된 배열에서 윗면을 0으로
		else diceTemp[idx - 3] = 0;
		
		Arrays.sort(diceTemp);	// 오름차순 정렬
		return diceTemp[5];	// 최대값 return
	}
}
