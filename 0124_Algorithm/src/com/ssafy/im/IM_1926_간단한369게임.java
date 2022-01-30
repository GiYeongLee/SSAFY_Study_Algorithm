package com.ssafy.im;

import java.util.Scanner;

public class IM_1926_간단한369게임 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String temp = new String();
		
		for(int i = 1; i < N + 1; i++) {
			temp = temp + Integer.toString(i) + " ";
		}
		
		String[] splited = temp.split(" ");
		
		for(int i = 0; i < splited.length; i++) {
			System.out.print(counting(splited[i]));
			System.out.print(" ");
		}
	}
	
	static String counting(String temp) {
		int flag = 0;
		for(int i = 0; i < temp.length(); i++) {
			if(temp.charAt(i) == '3' || temp.charAt(i) == '6' || temp.charAt(i) == '9') {
				flag++;
			}
		}
		if(flag == 0) {
			return temp;
		}
		else {
			String msg = new String();
			for(int i = 0; i < flag; i++) {
				msg = msg + "-";
			}
			return msg;
		}
	}
}
