package D3;

import java.io.*;
import java.util.*;

public class D3_13038_교환학생 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= TC; t++) {
			
			int n = Integer.parseInt(in.readLine());
			
			int[] arr = new int[7];
			Stack<Integer> stack = new Stack<Integer>();
			
			String[] splited = in.readLine().split(" ");
			for(int i = 0; i < 7; i++) {
				arr[i] = Integer.parseInt(splited[i]);
				if(arr[i] == 1) stack.push(i);
			}
			
			int min = Integer.MAX_VALUE;
			
			while(!stack.isEmpty()) {
				
				int idx = stack.pop();
				int count = 1;
				int ans = 1;
				
				while(count != n) {
					idx++;
					if(idx == 7) idx = 0;
					if(arr[idx] == 1) count++;
					ans++;
				}
				
				if(ans < min) min = ans;
			}
			
			builder.append("#" + t + " " + min + "\n");
		}
		builder.setLength(builder.length() - 1);
		System.out.println(builder.toString());
	}
}
