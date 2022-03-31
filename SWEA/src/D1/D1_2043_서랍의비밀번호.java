package D1;

import java.util.Scanner;

public class D1_2043_서랍의비밀번호 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int P = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println(P - K + 1);
		sc.close();
		System.exit(0);
	}
}
