import java.util.*;
import java.io.*;

public class BJ_2840_행운의바퀴 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		String[] splited = in.readLine().split(" ");
		
		int N = Integer.parseInt(splited[0]);
		int K = Integer.parseInt(splited[1]);
		
		char[] arr = new char[N];
		boolean[] used = new boolean[26];
		
		Arrays.fill(arr, '?');
		
		int idx = 0;
		
		for(int t = 0; t < K; t++) {
			
			splited = in.readLine().split(" ");
			
			int S = Integer.parseInt(splited[0]);
			char C = splited[1].charAt(0);
			
			idx = (idx + S) % N;
			
			if(arr[idx] == '?') {
				if(used[C - 'A'] == true) {
					System.out.println("!");
					return;
				}
				used[C - 'A'] = true;
				arr[idx] = C;
			}
			else if(arr[idx] != '?' && arr[idx] != C) {
				System.out.println("!");
				return;
			}
			
		}
		
		for(int i = 0; i < N; i++) {
			builder.append(arr[idx]);
			idx--;
			if(idx < 0) idx = N - 1;
		}
		
		System.out.println(builder.toString());
	}
}
