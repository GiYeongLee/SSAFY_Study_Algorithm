import java.io.*;
import java.util.*;

public class BJ_16120_PPAP {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();

	static Queue<Character> queue = new LinkedList<Character>();
	static char[] ppap = {'P', 'P', 'A', 'P'};
	static boolean flag = false;
	
	public static void main(String[] args) throws IOException {
		input();
		while(func());
		if(queue.size() == 1 && queue.peek() == 'P') System.out.print("PPAP");
		else System.out.print("NP");
	}
	
	static void input() throws IOException {
		String input = in.readLine();
		for(int i = 0; i < input.length(); i++) {
			queue.add(input.charAt(i));
		}
	}
	
	static boolean func() {
		Queue<Character> temp = new LinkedList<Character>();
		int idx = 0;
		flag = false;
		
		while(!queue.isEmpty()) {
			char a = queue.poll();
			if(a == ppap[idx]) idx++;
			else idx = 1;
			temp.add(a);
			if(idx == 4) {
				temp.poll(); temp.poll(); temp.poll();
				idx = 0;
				flag = true;
			}
		}
		queue = temp;
		return flag;
	}
}
