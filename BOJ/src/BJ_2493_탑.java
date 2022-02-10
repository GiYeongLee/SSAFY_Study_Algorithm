

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_2493_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		String[] temp = in.readLine().split(" ");
		Stack<int[]> stack = new Stack<int[]>();
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int[] a = {Integer.parseInt(temp[i]), i + 1};
			if(stack.empty()) {
				stack.push(a);
				builder.append("0 ");
			}
			else if(stack.peek()[0] >= a[0]) {
				builder.append(stack.peek()[1] + " ");
				stack.push(a);
			}
			else {
				while(true) {
					stack.pop();
					if(stack.empty()) {
						stack.push(a);
						builder.append("0 ");
						break;
					}
					if(stack.peek()[0] >= a[0]) {
						builder.append(stack.peek()[1] + " ");
						stack.push(a);
						break;
					}
				}
			}
		}
		System.out.printf("%s", builder.toString());
	}
}
