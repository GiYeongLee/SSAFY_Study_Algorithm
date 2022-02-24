import java.util.*;
import java.io.*;

public class BJ_2559_수열 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		
		int N = Integer.parseInt(splited[0]);
		int K = Integer.parseInt(splited[1]);
		
		int[] arr = new int[N];
		int[] ans = new int[N - K + 1];
		
		splited = in.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(splited[i]);
		}
		
		for(int i = 0; i < N - K + 1; i++) {
			for(int j = i; j < i + K; j++) {
				ans[i] += arr[j];
			}
		}
		
		Arrays.sort(ans);
		System.out.println(ans[ans.length - 1]);
	}	
}
