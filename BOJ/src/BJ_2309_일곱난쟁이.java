import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309_일곱난쟁이 {
	
	static int[] height = new int[9];
	static int[] temp = new int[9];
	static int[] ans = new int[7];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) height[i] = Integer.parseInt(in.readLine());
		func(0, 0, 0);
		Arrays.sort(ans);
		for(int i = 0; i < 7; i++) System.out.print(ans[i] + " ");
	}
	
	public static void func(int cnt, int idx, int sum) {
		if(cnt == 7 && sum == 100) {
			for(int i = 0; i < 7; i++) ans[i] = temp[i];
			return;
		}
		
		for(int i = idx; i < 9; i++) {
			temp[cnt] = height[i];
			func(cnt + 1, i + 1, sum + height[i]);
		}
	}
}
