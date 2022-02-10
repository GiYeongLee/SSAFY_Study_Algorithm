package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_1233_사칙연산유효성검사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {			
			int N = Integer.parseInt(in.readLine());			
			int flag = 1;	
			for(int i = 1; i <= N; i++) {
				String[] splited = in.readLine().split(" ");
				if(splited.length <= 2) {
					char temp = splited[1].charAt(0);
					if(temp == '+' || temp == '-' || temp == '*' || temp == '/') flag = 0;
				}
			}			
			System.out.println("#" + t + " " + flag);
		}		
	}
}
