import java.io.*;

public class BJ_14719_빗물 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int H, W, L, R;
	static int[] arr;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		input();
		func();
		System.out.println(answer);
	}
	
	public static void input() throws IOException {
		String[] splited = in.readLine().split(" ");
		H = Integer.parseInt(splited[0]);
		W = Integer.parseInt(splited[1]);
		arr = new int[W];
		
		
		splited = in.readLine().split(" ");
		for(int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(splited[i]);
		}
	}

	static void func() {
		for(int i = 1; i < W - 1; i++) {
			L = 0;
			R = 0;
			for(int j = 0; j < i; j++) {
				L = Math.max(L, arr[j]);
			}
			
			for(int j = W - 1; j > i; j--){
				R = Math.max(R, arr[j]);
			}
			
			if(arr[i] >= L || arr[i] >= R) continue;
			
			answer += (Math.min(L, R) - arr[i]);
			
			System.out.println(arr[i] +  " " + L + " " + R + " " + answer);
		}
	}
}
