import java.io.*;
import java.util.*;

public class JO_2577_회전초밥 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, d, k, c;
	static int[] arr;
	static int[] count;
	static int max = 0;
	static HashSet<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) throws IOException {
		input();
		func();
		System.out.println(max);
	}
	
	static void input() throws IOException {
		String[] splited = in.readLine().split(" ");
		N = Integer.parseInt(splited[0]);
		d = Integer.parseInt(splited[1]);
		k = Integer.parseInt(splited[2]);
		c = Integer.parseInt(splited[3]);
		arr = new int[N];
		count = new int[d + 1];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
	}
	
	static void func() {
		for(int i = 0; i < k; i++) {
			set.add(arr[i % N]);
			count[arr[i % N]]++;
		}
		if(!set.contains(c)) {
			max = Math.max(set.size() + 1, max);
		} else {
			max = Math.max(set.size(), max);
		}
		
		for(int i = 1; i < N; i++) {
			if(count[arr[(i - 1) % N]] > 1) {
				count[arr[(i - 1) % N]]--;
			} else {
				set.remove(arr[i - 1]);
				count[arr[(i - 1) % N]]--;
			}
			
			set.add(arr[(i + k - 1) % N]);
			count[arr[(i + k - 1) % N]]++;
			
			if(!set.contains(c)) {
				max = Math.max(set.size() + 1, max);
				continue;
			}
			max = Math.max(set.size(), max);
		}
	}

}
