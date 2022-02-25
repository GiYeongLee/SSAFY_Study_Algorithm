import java.io.*;

public class BJ_14696_딱지놀이 {
	
	// 4. 별(제일 쎔) > 3. 동그라미 > 2. 세모 > 1. 네모(제일 약함)
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		for(int round = 0; round < N; round++) {
			int[] scoreA = new int[5];
			int[] scoreB = new int[5];
			
			String[] A = in.readLine().split(" ");
			String[] B = in.readLine().split(" ");
			
			for(int i = 1; i <= Integer.parseInt(A[0]); i++) {
				scoreA[Integer.parseInt(A[i])]++;
			}
			for(int i = 1; i <= Integer.parseInt(B[0]); i++) {
				scoreB[Integer.parseInt(B[i])]++;
			}
			
			boolean draw = true;

			for(int i = 4; i >= 1; i--) {
				if(scoreA[i] > scoreB[i]) {
					builder.append("A\n");
					draw = false;
					break;
				}
				else if(scoreB[i] > scoreA[i]) {
					builder.append("B\n");
					draw = false;
					break;
				}
			}
			
			if(draw) builder.append("D\n");
		}
		
		System.out.println(builder.toString());
	}
	
}
