package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IM_1244_최대상금 {
	
	static int[] number;
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());

		for(int t = 1; t <= TC; t++) {
			
			max = 0;
			String[] splited = in.readLine().split(" ");
			number = new int[splited[0].length()];
			int count = Integer.parseInt(splited[1]);
			
			for(int i = 0; i < splited[0].length(); i++) {
				number[i] = splited[0].charAt(i) - '0';
			}
			func(0, 0, count);
			System.out.println("#" + t + " " + max);
		}
	}
	
	public static void func(int idx, int cnt, int count) {
		if(cnt == count) {
			StringBuilder builder = new StringBuilder();
			for(int i : number) builder.append(i);
			int num = Integer.parseInt(builder.toString());
			if(num > max) max = num;
			return;
		}
		
		for(int i = idx; i < number.length; i++) {
			for(int j = i + 1; j < number.length; j++) {
				if(number[i] < number[j]) {
					int temp = number[i];
					number[i] = number[j];
					number[j] = temp;
					func(i, cnt + 1, count);
					temp = number[i];
					number[i] = number[j];
					number[j] = temp;
				}
			}
		}
		if(cnt < count) {
			int temp = number[number.length - 1];
			number[number.length - 1] = number[number.length - 2];
			number[number.length - 2] = temp;
			func(idx, cnt + 1, count);
		}
	}
}
