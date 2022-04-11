import java.io.*;

public class BJ_3020_개똥벌레 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N, H;
	static int[] top, bottom, count;
	static int min = Integer.MAX_VALUE;
	
	static void input() throws IOException {
		String[] splited = in.readLine().split(" ");
		N = Integer.parseInt(splited[0]);
		H = Integer.parseInt(splited[1]);
		top = new int[H + 1];
		bottom = new int[H + 1];
		count = new int[H + 1];
		
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(in.readLine());
			if(i % 2 == 0) {
				bottom[input]++;
			} else {
				top[input]++;
			}
		}
		
		// 누적합
		for(int i = H - 1; i > 0 ; i--) {
			bottom[i] += bottom[i + 1];
			top[i] += top[i + 1];
		}
		
		for(int i = 1; i <= H; i++) {
			count[i] = bottom[i] + top[H - i + 1];
			min = Math.min(min, count[i]);
		}	
	}
	
	static int count() {
		int cnt = 0;
		for(int i = 1; i <= H; i++) {
			if(count[i] == min) cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(min +  " " + count());
	}
}
