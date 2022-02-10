import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2491_수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int pCount = 1;
		int mCount = 1;
		int sameCount = 0;
		int max = 1;
		
		int prevNum = Integer.parseInt(st.nextToken());	
		for(int i = 0; i < N - 1; i++) {
			int nextNum = Integer.parseInt(st.nextToken());
			if(prevNum == nextNum) {
				pCount++; mCount++; sameCount++;
			}
			else if(prevNum < nextNum) {
				pCount++;
				if(mCount > max) max = mCount;
				mCount = 1;
			}
			else if(prevNum > nextNum) {
				mCount++;
				if(pCount > max) max = pCount;
				pCount = 1;
			}
			prevNum = nextNum;
		}
		if(mCount > max) max = mCount;
		if(pCount > max) max = pCount;
		
		if(sameCount == N - 1) System.out.println(pCount);
		else System.out.println(max);
	}
}
