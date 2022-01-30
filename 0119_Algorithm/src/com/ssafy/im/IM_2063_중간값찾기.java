package com.ssafy.im;

import java.util.Arrays;
import java.util.Scanner;

public class IM_2063_중간값찾기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		int[] arr = new int[TC];
		
		for(int t = 0; t < TC; t++) {
			arr[t] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		System.out.print(arr[(TC / 2)]);
	}
}
