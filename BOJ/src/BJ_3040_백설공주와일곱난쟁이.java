import java.util.*;
import java.io.*;

public class BJ_3040_백설공주와일곱난쟁이 {

	static int[] person = new int[9];
	static int[] ans = new int[7];
	
	static StringBuilder builder = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) person[i] = Integer.parseInt(in.readLine());
		
		func(0, 0);
	}
	
	static void func(int cnt, int idx) {
		if(cnt == 7) {
			int sum = 0;
			for(int i = 0; i < 7; i++) {
				sum += ans[i];
			}
			if(sum == 100) {
				for(int i = 0; i < 7; i++) {
					builder.append(ans[i] + "\n");
				}
				builder.setLength(builder.length() - 1);
				System.out.println(builder.toString());
			}
			return;
		}
		
		for(int i = idx; i < 9; i++) {
			
			ans[cnt] = person[i];
			func(cnt + 1, i + 1);
			
		}
	}

}
