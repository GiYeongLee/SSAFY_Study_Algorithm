

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729_하노이탑이동순서 {
	
	static void func(int N, int from, int middle, int to) {	
		if(N == 1) {
			System.out.println(from + " " + to);
			return;
		}
		
		func(N - 1, from, to, middle);		
		System.out.println(from + " " + to);		
		func(N - 1, middle, from, to);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		func(N, 1, 2, 3);
	}
}
