package com.ssafy.im;

import java.util.Scanner;

public class IM_2025_N줄덧셈 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int sum = 0;
		
		while(num != 0) {
			sum += num;
			num--;
		}
		
		System.out.println(sum);
		System.exit(0);
	}
}
