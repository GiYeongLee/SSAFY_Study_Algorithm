package D2;

import java.util.Scanner;

public class D2_1288_새로운불면증치료법 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int TC = in.nextInt();
		in.nextLine();
		
		for(int t = 1; t <= TC; t++) {
			
			boolean[] flag = new boolean[10];
			boolean end = true;
			int count = 0;
			String N = in.nextLine();
			long k = Long.parseLong(N);
			
			while(end) {
				int a = 0;
				for(int i = 0; i < N.length(); i++) {
					int temp = (N.charAt(i) - '0');
					flag[temp] = true;
				}
				for(int i = 0; i < 10; i++) {
					if(flag[i] == false) {
						count++;
						break;
					}
					a++;
				}
				if(a == 10) {
					System.out.println("#" + t + " " + ((count + 1) * k));
					break;
				}
				N = Long.toString((Long.parseLong(N) + k));
			}
		}

		in.close();
	}
}
