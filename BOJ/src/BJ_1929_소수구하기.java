import java.io.*;

public class BJ_1929_소수구하기 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		input();
		check();
		func();
		System.out.println(builder.toString());
	}

	static int M, N;
	static boolean[] arr;
	
	static void input() throws IOException {
		String[] splited = in.readLine().split(" ");
		M = Integer.parseInt(splited[0]);
		N = Integer.parseInt(splited[1]);
		arr = new boolean[1000001];
		arr[1] = true;
	}
	
	static void check() {
		for(int i = 2; i <= N; i++) {
			for(int j = 2; j <= N; j++) {
				if(i * j > N) break;
				arr[i * j] = true;
			}
		}
	}
	
	static void func() {
		for(int i = M; i <= N; i++) {
			if(!arr[i]) builder.append(i + "\n");
		}
	}
}
