package com.ssafy.im;

import java.util.Scanner;

public class IM_1936_1대1가위바위보 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input;
		
		int numA = sc.nextInt();
		int numB = sc.nextInt();
		
		switch(numA) {
		case 1:
			switch(numB) {
			case 2:
				System.out.println("B");
			case 3:
				System.out.println("A");
			}
			break;
		case 2:
			switch(numB) {
			case 1:
				System.out.println("A");
			case 3:
				System.out.println("B");
			}
			break;
		case 3:
			switch(numB) {
			case 1:
				System.out.println("B");
			case 2:
				System.out.println("A");
			}
			break;
		}
		
		System.exit(0);
	}
	
}
