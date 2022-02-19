package D4;

import java.io.*;

public class D4_3234_준환이의양팔저울 {
	
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(in.readLine());
			int[] weight = new int[N];
			boolean[] isSelected = new boolean[N];
			count = 0;
			
			String[] splited = in.readLine().split(" ");
			for(int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(splited[i]);
			}
			
			dfs(N, 0, 0, 0, weight, isSelected);
			
			builder.append("#" + t + " " + count + "\n");
		}
		System.out.println(builder);
	}
	
	static void dfs(int N, int cnt, int leftWeight, int rightWeight, int[] weight, boolean[] isSelected) {
		if(cnt == N) {
			count++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isSelected[i] == true) continue;
			isSelected[i] = true;
			dfs(N, cnt + 1, leftWeight + weight[i], rightWeight, weight, isSelected);	// 기본으로 왼쪽에 올리기
			if(leftWeight >= rightWeight + weight[i]) {	// 오른쪽에 올리더라도 왼쪽 무게보다 작으면 경우의 수에 추가
				dfs(N, cnt + 1, leftWeight, rightWeight + weight[i], weight, isSelected);
			}
			isSelected[i] = false;
		}
	}

}
