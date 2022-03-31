package D2;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1966_숫자를정렬하자 {
	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);
		int TC = in.nextInt();
		for(int t = 1; t <= TC; t++) {
			int N = in.nextInt();
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = in.nextInt();
			}
			Arrays.sort(arr);
			System.out.print("#" + t);
			for(int i = 0; i < N; i++) {
				System.out.print(" " + arr[i]);
			}
			System.out.println();
		}

		in.close();
	}
}
