package D3;

import java.io.*;

public class D3_5607_조합 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();
	
	static long A = 1234567891;
	static int N, R;
	static long[] factorial;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int TC = Integer.parseInt(in.readLine());
		for(int t = 1; t <= TC; t++) {
			initFactorial();
			input();
			func(t);
		}
		System.out.println(builder.toString());
	}
	
	static void initFactorial() {
		factorial = new long[1000001];
		factorial[0] = 1;
		for(int i = 1; i < 1000001; i++) {
			factorial[i] = (factorial[i - 1] * i) % A;
		}
	}
	
	static void input() throws IOException {
		String[] splited = in.readLine().split(" ");
		N = Integer.parseInt(splited[0]);
		R = Integer.parseInt(splited[1]);
	}
	
	static void func(int t) {
		long bottom = (factorial[R] * factorial[N - R]) % A;
		bottom = pow(bottom,  A - 2);	
		builder.append("#" + t + " " + (factorial[N] * bottom) % A + "\n");
	}
	
	static long pow(long base, long power) {
		if(power == 0) return 1;
		
		long half = pow(base, power / 2);		
		if(power % 2 == 0) return ((half % A) * (half % A)) % A;
		else return ((((half % A) * (half % A)) % A) * base) % A;
	}
}
