package com.ssafy.im;

import java.util.Scanner;

public class IM_2050_알파벳을숫자로변환 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		for(int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i) - 'A' + 1 + " ");
		}
		
	}
}
