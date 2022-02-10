package D2;

import java.util.Scanner;

public class D2_1986_지그재그숫자 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int i = 1; i <= TC; i++) {
			int N = sc.nextInt();
			int flag = 0;
			int sum = 0;
			
			for(int j = 1; j <= N; j++) 
				switch(flag) {
				case 0:
					sum += j;
					flag++;
					break;
				case 1:
					sum -= j;
					flag--;
					break;
			}
			
			System.out.println("#" + i + " " + sum);
		}
	}
}
