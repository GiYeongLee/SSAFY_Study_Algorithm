package D2;

import java.util.Scanner;

public class D2_1945_간단한소인수분해 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int i = 1; i <= TC; i++) {
			
			int N = sc.nextInt();
			int[] arr = {0, 0, 0, 0, 0};
			
			while (N != 1) {
				
				if(N % 2 == 0) {
					arr[0]++;
					N = N / 2;
				}
				else if(N % 3 == 0) {
					arr[1]++;
					N = N / 3;
				}
				else if(N % 5 == 0) {
					arr[2]++;
					N = N / 5;
				}
				else if(N % 7 == 0) {
					arr[3]++;
					N = N / 7;
				}
				else if(N % 11 == 0) {
					arr[4]++;
					N = N / 11;
				}
				
			}
			
			System.out.print("#" + i + " ");
			for(int j : arr) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

		sc.close();

	}

}
