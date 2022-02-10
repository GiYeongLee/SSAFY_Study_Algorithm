package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class D3_3499_퍼펙트셔플 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= TC; t++) {
			int len = Integer.parseInt(in.readLine());
			int cut = 0;
			if(len % 2 == 0) cut = len / 2;
			else if(len % 2 == 1) cut = len / 2 + 1;
			
			String[] card = in.readLine().split(" ");
			
			Queue<String> queue1 = new LinkedList<String>();
			Queue<String> queue2 = new LinkedList<String>();
			
			for(int i = 0; i < len; i++) {
				if(i < cut) queue1.offer(card[i]);
				else queue2.offer(card[i]);
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < (len / 2) + 1; i++) {
				if(!queue1.isEmpty()) System.out.print(queue1.poll() + " ");
				if(!queue2.isEmpty()) System.out.print(queue2.poll() + " ");
			}
			System.out.println();	
		}
	}
}
