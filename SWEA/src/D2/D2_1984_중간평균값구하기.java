package D2;

import java.util.Scanner;

public class D2_1984_중간평균값구하기 {
	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);	
		int TC = in.nextInt();	
		for(int t = 1; t <= TC; t++) {
			int[] arr = new int[10];
			int min = 10000;
			int max = 0;
			int sum = 0;	
			for(int i = 0; i < arr.length; i++) {
				arr[i] = in.nextInt();
				sum += arr[i];
				if(arr[i] > max) {
					max = arr[i];
				}
				else if(arr[i] < min) {
					min = arr[i];
				}
			}		
			System.out.printf("#%d %.0f\n", t, (1.0) * (sum - min - max) / 8);
		}
	}
}
