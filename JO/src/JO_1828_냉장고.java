

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JO_1828_냉장고 {
	static class a implements Comparable<a>{
		
		int start, end;
		
		public a(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(a o) {
			return (this.end != o.end) ? this.end - o.end : this.start - o.start;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		a[] arr = new a[N];
		int count = 1;
	 
		for(int i = 0; i < N; i++) {
			String[] splited = in.readLine().split(" ");
			arr[i] = new a(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]));
		}
		
		Arrays.sort(arr);		
		a temp = arr[0];
		
		for(int i = 1; i < N; i++) {
			if(temp.end < arr[i].start) {
				count++;
				temp = arr[i];
			}
		}
		
		System.out.println(count);
	}
}
