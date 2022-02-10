package D2;

import java.util.Scanner;

public class D2_1940_가랏RC카 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int TC = in.nextInt();
		
		for(int t = 1; t <= TC; t++) {
			
			int count = in.nextInt();
			int speed = 0;
			int location = 0;
			
			for(int c = 0; c < count; c++) {
				
				int X = in.nextInt();
				if(X == 0) {
					location += speed;
					continue;
				}
				int Y = in.nextInt();
				switch(X){
				case 1:
					speed += Y;
					location += speed;
					break;
				case 2:
					speed -= Y;
					if(speed < 0) {
						speed = 0;
					}
					location += speed;
					break;
				}
			}
			System.out.println("#" + t + " " + location);
			
		}
	}
}
