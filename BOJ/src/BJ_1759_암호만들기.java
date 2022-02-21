import java.io.*;
import java.util.*;

public class BJ_1759_암호만들기 {

	static StringBuilder builder = new StringBuilder();
	static int L, C;
	static char[] arr;
	static char[] password;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		password = new char[L];
		arr = new char[C];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		
		func(0, 0);
		System.out.println(builder);
	}
	
	static void func(int cnt, int idx) {
		if(cnt == L) {
			func2(password);
			return;
		}
		
		for(int i = idx; i < C; i++) {
			password[cnt] = arr[i];
			func(cnt + 1, i + 1);
		}
	}
	
	static void func2(char[] password) {
		int count1 = 0;
		int count2 = 0;
		for(int i = 0; i < L; i++) {
			if(password[i] == 'a' || password[i] == 'e' || password[i] == 'i' || password[i] == 'o' || password[i] == 'u') count1++;
			else count2++;
		}
		if(count1 >= 1 && count2 >= 2) {
			for(int i = 0; i < L; i++) {
				builder.append(password[i]);
			}
			builder.append("\n");
		}
	}
}
