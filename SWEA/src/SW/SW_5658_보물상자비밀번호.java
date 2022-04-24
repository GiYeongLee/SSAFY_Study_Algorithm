package SW;

import java.io.*;
import java.util.*;

public class SW_5658_보물상자비밀번호 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();

	static int N, K, answer;
	static String str;
	static Set<Integer> set;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int TC = Integer.parseInt(in.readLine());
		for(int t = 1; t <= TC; t++) {
			input();
			builder.append("#" + t + " " + answer + "\n");
		}
		System.out.println(builder.toString());
	}
	
	static void input() throws IOException {
		set = new HashSet<Integer>();
		String[] splited = in.readLine().split(" ");
		N = Integer.parseInt(splited[0]);
		K = Integer.parseInt(splited[1]);	
		str = in.readLine();
		func();
	}
	
	static void func() {
		int side = N / 4;	// 한 변의 숫자 갯수
		for(int i = 0; i < side; i++) {
			int index = i;
			for(int j = 0; j < 4; j++) {
				String temp = str.substring(index, index + side);	// 한 변의 16진수 추출
				int num = Integer.parseInt(temp, 16);	// 16진수 변환
				set.add(num);	// 중복 제거
				index += side;
			}
			str = str + str.charAt(i);
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		answer = list.get(list.size() - K);
	}
}
