import java.io.*;

public class BJ_9372_상근이의여행 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());

		for(int t = 1; t <= TC; t++) {
			
			String[] splited = in.readLine().split(" ");
			
			int N = Integer.parseInt(splited[0]);	// 국가의 수(정점)
			int M = Integer.parseInt(splited[1]);	// 비행기의 종류(간선)

			for(int i = 0; i < M; i++) {
				in.readLine();
			}
			
			builder.append((N - 1) + "\n");
		}
		System.out.println(builder.toString());
	}

}
