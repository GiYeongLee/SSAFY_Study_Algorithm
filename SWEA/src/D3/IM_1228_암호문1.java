package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class IM_1228_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			
			int N = Integer.parseInt(in.readLine());
			String[] splited = in.readLine().split(" ");
			
			LinkedList<Integer> list = new LinkedList<Integer>();
			
			for(int i = 0; i < N; i++) list.offer(Integer.parseInt(splited[i]));
			
			int N2 = Integer.parseInt(in.readLine());
			String command = in.readLine();
			StringTokenizer st = new StringTokenizer(command);
			
			for(int i = 0; i < N2; i++) {
				st.nextToken();
				int loc = Integer.parseInt(st.nextToken());
				int N3 = Integer.parseInt(st.nextToken());
				for(int j = loc; j < loc + N3; j++) {
					list.add(j, Integer.parseInt(st.nextToken()));
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < 10; i++) System.out.print(list.poll() + " ");
			System.out.println();
		}

	}

}
