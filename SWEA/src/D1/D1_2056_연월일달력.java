package D1;

import java.util.Scanner;

public class D1_2056_연월일달력 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		sc.nextLine();
		for(int t = 1; t <= TC; t++) {
			String str = sc.nextLine();
			String month = str.substring(4, 6);
			String date = str.substring(6, 8);
			if(Integer.parseInt(month) > 12 || Integer.parseInt(month) == 0) {
				System.out.println("#" + t + " " + -1);
				continue;
			}
			int flag = 1;
			switch(Integer.parseInt(month)) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if(Integer.parseInt(date) > 31 || Integer.parseInt(date) == 0) {
					System.out.println("#" + t + " " + -1);
					flag = 0;
				}
				break;
			case 2:
				if(Integer.parseInt(date) > 28 || Integer.parseInt(date) == 0) {
					System.out.println("#" + t + " " + -1);
					flag = 0;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if(Integer.parseInt(date) > 30 || Integer.parseInt(date) == 0) {
					System.out.println("#" + t + " " + -1);
					flag = 0;
				}
				break;
			}
			if(flag == 1) {
				System.out.println("#" + t + " " + str.substring(0, 4) + "/" + month + "/" + date);
			}
		}
		sc.close();
	}
}
