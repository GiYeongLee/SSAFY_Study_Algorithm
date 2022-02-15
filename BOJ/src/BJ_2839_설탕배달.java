

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2839_설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		int count = 0;
		
		while(N > 0) {		
			if(N % 5 == 0) {
				N -= 5;
				count++;
				continue;
			}		
			N -= 3;
			count++;
		}
		if(N < 0) count = -1;
		
		builder.append(count);
		System.out.println(builder.toString());
	}

}
