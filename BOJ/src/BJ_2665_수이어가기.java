import java.util.*;
import java.io.*;

public class BJ_2665_수이어가기 {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		LinkedList<Integer> ans = new LinkedList<Integer>();
		int max = 0;
		
		for(int i = 0; i <= N; i++) {
			LinkedList<Integer> arr = new LinkedList<Integer>();
			arr.add(N);
			arr.add(i);
			int temp = N - i;
			int idx = 2;
			while(temp >= 0) {
				if(arr.get(idx - 2) - arr.get(idx - 1) < 0) break;
				arr.add(arr.get(idx - 2) - arr.get(idx - 1));
				idx++;
				temp = arr.get(idx - 2) - arr.get(idx - 1);
				
			}
			if(arr.size() > max) {
				max = arr.size();
				ans = (LinkedList<Integer>) arr.clone();
			}
		}
		
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < max; i++) builder.append(ans.get(i) + " ");
		
		System.out.println(max);
		System.out.println(builder.toString());
		
	}
	
	

}
