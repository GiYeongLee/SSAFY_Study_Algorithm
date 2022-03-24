import java.io.*;

public class BJ_13458_시험감독 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(in.readLine());
		long[] A = new long[(int) N];
		String[] splited = in.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			A[i] = Long.parseLong(splited[i]);
		}
		splited = in.readLine().split(" ");
		long B = Long.parseLong(splited[0]);
		long C = Long.parseLong(splited[1]);
		
		long count = 0;
		
		for(int i = 0; i < N; i++) {
			A[i] -= B;
			count++;
			
			if(A[i] <= 0) continue;
			else {
				count += (A[i] / C);
				if(A[i] % C != 0) count++;
			}
		}
		
		System.out.println(count);
	}

}
