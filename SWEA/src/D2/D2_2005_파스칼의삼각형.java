package D2;

import java.util.Scanner;

public class D2_2005_파스칼의삼각형 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int t = 0; t < TC; t++) {
			int N = sc.nextInt();
			int[] arr = new int[10];
			int[] temp = new int[10];
			int count = 1;
			System.out.println("#" + (t + 1));
			for(int i = 0; i < N; i++) {
				arr = temp.clone();
				for(int j = 0; j < count; j++) {
					if(j == 0) {
						System.out.print(1 + " ");
						temp[j] = 1;
						continue;
					}
					temp[j] = arr[j - 1] + arr[j];
					System.out.print(temp[j] + " ");
				}
				System.out.println();
				count++;
			}
		}

		sc.close();
	}
}
