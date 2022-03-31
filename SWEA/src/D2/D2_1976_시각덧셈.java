package D2;

import java.util.Scanner;

public class D2_1976_시각덧셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		int[] hour = new int[TC];
		int[] min = new int[TC];
		
		for(int t = 0; t < TC; t++) {
			int firstHour = sc.nextInt();
			int firstMin = sc.nextInt();
			int secHour = sc.nextInt();
			int secMin = sc.nextInt();
			
			int sumMin = firstMin + secMin;
			int sumHour = firstHour + secHour;
			
			if(sumMin >= 60) {
				sumMin -= 60;
				sumHour++;
			}
			
			if(sumHour > 12) {
				sumHour -= 12;
			}
			
			hour[t] = sumHour;
			min[t] = sumMin;
		}
		
		for(int i = 0; i < hour.length; i++) {
			System.out.println("#" + (i + 1) + " " + hour[i] + " " + min[i]);
		}

		sc.close();
	}
}
