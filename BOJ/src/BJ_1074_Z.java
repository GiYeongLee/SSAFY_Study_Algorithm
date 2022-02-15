

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1074_Z {
	
	static int ans = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		
		int N = Integer.parseInt(splited[0]);
		int r = Integer.parseInt(splited[1]);
		int c = Integer.parseInt(splited[2]);

		int length = (int) Math.pow(2, N);
		
		func(length, r, c);
		
		System.out.println(ans);
		
	}

	public static void func(int length, int r, int c) {
		
		if(length == 1) return;
		
		if(r < (length / 2) && c < (length / 2)) {
			func((length / 2), r, c);
		}
		else if(r < (length / 2) && c >= (length / 2)) {
			ans += Math.pow(length / 2, 2);
			func((length / 2), r, (c  - (length / 2)));
		}
		else if(r >= (length / 2) && c < (length / 2)) {
			ans += Math.pow(length / 2, 2) * 2;
			func((length / 2), (r  - (length / 2)), c);
		}
		else if(r >= (length / 2) && c >= (length / 2)) {
			ans += Math.pow(length / 2, 2) * 3;
			func((length / 2), (r  - (length / 2)), (c  - (length / 2)));
		}
	}
}
