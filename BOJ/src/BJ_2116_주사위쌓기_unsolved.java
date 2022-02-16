import java.io.*;
import java.util.*;


public class BJ_2116_주사위쌓기_unsolved {
	
	static int N;
	static int[][] dice;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());	// 주사위의 개수
		dice = new int[N][6];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			dice[i][0] = Integer.parseInt(st.nextToken());	// i + 3 은 주사위의 반대편
			dice[i][1] = Integer.parseInt(st.nextToken());
			dice[i][2] = Integer.parseInt(st.nextToken());
			dice[i][4] = Integer.parseInt(st.nextToken());
			dice[i][5] = Integer.parseInt(st.nextToken());
			dice[i][3] = Integer.parseInt(st.nextToken());
		}
		
		
		
		
	}
	
	public static void func(int cnt, int prevDiceNum) {
		
		
		for(int i = 0; i < 6; i++) {
			if(dice[cnt][i] != prevDiceNum) continue;
			
		}
	}

}
