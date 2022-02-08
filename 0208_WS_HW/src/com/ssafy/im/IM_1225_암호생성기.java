package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class IM_1225_암호생성기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				
		for(int t = 1; t <= 10; t++) {
			LinkedList<Integer> queue = new LinkedList<Integer>();
			in.readLine();
			String[] splited = in.readLine().split(" ");
			for(int i = 0; i < 8; i++) queue.offer(Integer.parseInt(splited[i]));

			int flag = 0;
			while(true) {
				for(int i = 1; i <= 5; i++) {
					int temp = queue.poll() - i;
					if(temp <= 0) {
						temp = 0;
						flag = 1;
						queue.offer(temp);
						break;
					}
					queue.offer(temp);
				}
				if(flag == 1) {
					System.out.print("#" + t + " ");
					while(queue.isEmpty() != true) System.out.print(queue.poll() + " ");
					System.out.println();
					break;
				}
			}
		}
	}
}
