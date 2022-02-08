package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IM_1208_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(in.readLine());
			int[] box = new int[100];
			String temp = in.readLine();
			String[] splited = temp.split(" ");
			for(int i = 0; i < splited.length; i++) {
				box[i] = Integer.parseInt(splited[i]);
			}
				
			while(N > 0) {
				
				Arrays.sort(box);
				
				box[0]++;
				box[99]--;
				
				N--;
			}
			Arrays.sort(box);
			System.out.println("#" + t + " " + (box[99] - box[0]));
		}
	}

}
