package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class D4_1224_계산기3 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Integer> priority = new HashMap<Character, Integer>();
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('(', 0);
		priority.put(')', 0);
		
		for(int t = 1; t <= 10; t++) {
			Stack<String> com = new Stack<String>();
			StringBuilder builder = new StringBuilder();
			in.readLine();
			String str = in.readLine();
			for(int i = 0; i < str.length(); i++) {		
				char temp = str.charAt(i);
				if(temp == '+' || temp == '-' || temp == '*' || temp == '/') {
					if(com.isEmpty()) com.push(Character.toString(temp));
					else{
						while(com.isEmpty() == false) {
							if(priority.get(com.peek().charAt(0)) >= priority.get(temp)) builder.append(com.pop());
							else break;
						}
						com.push(Character.toString(temp));
					}
				}
				else if(temp == '(') com.push(Character.toString(temp));
				else if(temp == ')') {
					while(true) {
						if(com.peek().charAt(0) == '(') {
							com.pop();
							break;
						}
						builder.append(com.pop());
					}
				}
				else builder.append(temp);
			}			
			while(!com.isEmpty()) builder.append(com.pop());
			
			for(int i = 0; i < builder.length(); i++) {
				char temp = builder.toString().charAt(i);
				int n1;
				int n2;
				switch(temp) {
				case '+':
					n1 = Integer.parseInt(com.pop());
					n2 = Integer.parseInt(com.pop());
					com.push(Integer.toString(n2 + n1));
					break;
				case '-':
					n1 = Integer.parseInt(com.pop());
					n2 = Integer.parseInt(com.pop());
					com.push(Integer.toString(n2 - n1));
					break;
				case '*':
					n1 = Integer.parseInt(com.pop());
					n2 = Integer.parseInt(com.pop());
					com.push(Integer.toString(n2 * n1));
					break;
				case '/':
					n1 = Integer.parseInt(com.pop());
					n2 = Integer.parseInt(com.pop());
					com.push(Integer.toString(n2 / n1));
					break;
				default:
					com.push(Character.toString(temp));
					break;
				}
			}
			System.out.println("#" + t + " " + com.pop());
		}
	}
}
