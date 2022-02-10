package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D3_1234_비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			String[] splited = in.readLine().split(" ");
			int len = Integer.parseInt(splited[0]);
			Stack<Integer> stack = new Stack<Integer>();
			
			for(int i = 0; i < len; i++) {
				int num = splited[1].charAt(i) - '0';
				if(stack.empty()) {
					stack.push(num);
					continue;
				}			
				if(stack.peek() == num) stack.pop();
				else stack.push(num);				
			}
			
			int[] password = new int[stack.size()];
			int i = stack.size() - 1;
			
			while(stack.empty() != true) {
				password[i] = stack.pop();
				i--;
			}
			System.out.print("#" + t + " ");
			for(int j = 0; j < password.length; j++) System.out.print(password[j]);
			System.out.println();
		}
	}
}
