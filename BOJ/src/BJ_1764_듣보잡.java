import java.io.*;
import java.util.*;

public class BJ_1764_듣보잡 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();
	
	static HashSet<String> set = new HashSet<String>();
	static PriorityQueue<String> pq = new PriorityQueue<String>();
	
	public static void main(String[] args) throws Exception {
		input();
		System.out.println(builder.toString());
	}
	
	static void input() throws Exception {
		String[] splited = in.readLine().split(" ");
		int N = Integer.parseInt(splited[0]);
		int M = Integer.parseInt(splited[1]);
		int count = 0;
		
		String[] a = new String[N];
		
		for(int i = 0; i < N; i++) {
			set.add(in.readLine());
		}
		for(int i = 0; i < M; i++) {
			String temp = in.readLine();
			if(set.contains(temp)) {
				pq.add(temp);
				count++;
			}
		}
		
		builder.append(count + "\n");
		while(!pq.isEmpty()) {
			builder.append(pq.poll() + " ");
		}
		
	}

}
