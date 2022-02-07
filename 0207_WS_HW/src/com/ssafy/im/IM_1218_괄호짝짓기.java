package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class IM_1218_괄호짝짓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			
			int TC = Integer.parseInt(in.readLine());
			String str = in.readLine();
			Stack<Character> stack = new Stack<Character>();
			boolean correct = true;
			
			for(int i = 0; i < TC; i++) {
				if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '<') stack.push(str.charAt(i));
				else {
					if(stack.empty() == true) {
						correct = false;
						break;
					}
					char temp = stack.pop();
					if(temp == '(' && str.charAt(i) == ')') continue;
					else if(temp == '[' && str.charAt(i) == ']') continue;
					else if(temp == '<' && str.charAt(i) == '>') continue;
					else if(temp == '{' && str.charAt(i) == '}') continue;
					else {
						correct = false;
						break;
					}
				}
			}
			if(stack.empty() == true && correct == true) System.out.println("#" + t + " " + 1);
			else System.out.println("#" + t + " " + 0);
		}
	}
}
