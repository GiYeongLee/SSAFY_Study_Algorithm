package D4;

import java.io.*;

public class D4_8458_원점으로집합 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int TC = Integer.parseInt(in.readLine());
		for(int t = 1; t <= TC; t++) {
			func(t);
		}
		System.out.println(builder.toString());
	}
	
	static void func(int t) throws NumberFormatException, IOException {
		int N = Integer.parseInt(in.readLine());
		int max = Integer.MIN_VALUE;
		boolean even = false;
		boolean odd = false;
		
		for(int i = 0; i < N; i++) {
			String[] splited = in.readLine().split(" ");
			int x = Integer.parseInt(splited[0]);
			int y = Integer.parseInt(splited[1]);
			int temp = Math.abs(x) + Math.abs(y);
			max = Math.max(temp, max);
			
			if(temp % 2 == 0) even = true;
			else odd = true;
		}
		
		if(even && odd) {
			builder.append("#" + t + " -1\n");
			return;
		}
		
		int answer = 0;
		int sum = 0;
		int temp = 0;
		while(true) {
			sum += temp;
			if(max <= sum && (max % 2) == (sum % 2)) {
				answer = temp;
				break;
			}
			temp++;
		}

		builder.append("#" + t + " " + answer + "\n");
	}
}
