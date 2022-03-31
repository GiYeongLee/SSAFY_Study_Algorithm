package D1;

import java.util.Scanner;

public class D1_2071_평균값구하기 {

	public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			int T = sc.nextInt();
			
			for(int j = 0; j < T; j++) {
				int sum = 0;
				double avg;
				for(int i = 0; i < 10; i++) {
					int num = sc.nextInt();
					sum += num;
				}
				avg = (double)sum / 10;
				
				System.out.printf("#%d %.0f\n", (j + 1), avg);
			}

			sc.close();

		}

}
