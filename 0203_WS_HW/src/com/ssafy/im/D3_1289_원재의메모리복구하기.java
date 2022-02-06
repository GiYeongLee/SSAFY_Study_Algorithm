package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1289_원재의메모리복구하기 {
	
	public static void main(String[] args) throws IOException {	
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		
		for(int T = 1; T <= tc; T++) {
			String str = in.readLine();
	
			char[] arr = new char[str.length()];
			
			for(int i = 0; i < str.length(); i++) {	
				arr[i] = str.charAt(i);
			}
			
			int count = 0;

			char flag = arr[0];
			if(flag == '1') {
				count++;
			}
			
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] != flag) {
					flag = arr[i];
					count++;
				}
			}	
			System.out.println("#" + T + " " + count);	
		}
	}
}
