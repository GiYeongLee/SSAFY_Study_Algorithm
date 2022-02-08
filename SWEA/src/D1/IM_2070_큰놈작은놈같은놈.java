package D1;

import java.util.Scanner;

public class IM_2070_큰놈작은놈같은놈 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int TC = in.nextInt();
		
		for(int t = 1; t <= TC; t++) {
			
			int x = in.nextInt();
			int y = in.nextInt();
			
			if(x < y) {
				System.out.println("#" + t + " " + "<");
			}
			else if(x > y) {
				System.out.println("#" + t + " " + ">");
			}
			else if(x == y) {
				System.out.println("#" + t + " " + "=");
			}
		}
		
	}
}
