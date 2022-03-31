package D2;

import java.util.Scanner;

public class D2_1989_초심자의회문검사 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc = 1; tc <= TC; tc++) {
			
			String str = sc.next();
			
			int flag = 0;
			
			for(int i = 0; i < (str.length() / 2); i++){	
				if(str.charAt(i) == str.charAt(str.length() - i - 1)) {
					flag = 1;
					continue;
				}
				else {
					flag = 0;
					break;
				}
			}
			if(flag == 1) {
				System.out.println("#" + tc + " " + 1);
			}
			else {
				System.out.println("#" + tc + " " + 0);
			}
			
		}

		sc.close();
	}
	
}
