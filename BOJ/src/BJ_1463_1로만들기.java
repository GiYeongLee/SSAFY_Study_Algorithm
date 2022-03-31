

import java.io.*;

public class BJ_1463_1로만들기 {
	
	static int answer = Integer.MAX_VALUE;
	
	static boolean flag = false;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Integer.parseInt(in.readLine());
		
		//func1(N, 0);
		func2(N);
		
		System.out.println(answer);

	}
	
	public static void func1 (long N, int count) {
		
		if(N == 1) {
			answer = Math.min(answer, count);
			flag = true;
			return;
		}
		
		if(count >= answer && flag) return;
		
		if(N % 3 == 0) {
			func1(N / 3, count + 1);
		}
		
		if(N % 2 == 0) {
			func1(N / 2, count + 1);
		}
		
		func1(N - 1, count + 1);
		
	}
	
	public static void func2 (long N) {
		
		int[] M = new int[(int)N + 1];
		
		M[1] = 0;
		
		for(int i = 2; i <= N; i++) {
			
			M[i] = M[i - 1] + 1;
			
			if(i % 2 == 0) {
				M[i] = Math.min(M[i],  M[i / 2] + 1);
			}
			
			if(i % 3 == 0) {
				M[i] = Math.min(M[i], M[i / 3] + 1);
			}
			
		}
		
		answer = M[(int)N];
		
	}

}
