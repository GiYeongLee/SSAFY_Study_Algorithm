package D2;

import java.util.Scanner;

public class D2_1284_수도요금경쟁 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int i = 1; i <= TC; i++) {
			
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			
			int A_pay = W * P;
			int B_pay = 0;
			
			if(W <= R) {
				B_pay = Q;
			}
			else if(W > R) {
				B_pay = Q + ((W - R) * S);
			}
			
			if(A_pay > B_pay) {
				System.out.println("#" + i + " " + B_pay);
			}
			else if(A_pay < B_pay) {
				System.out.println("#" + i + " " + A_pay);
			}
			
		}
		sc.close();

	}

}
