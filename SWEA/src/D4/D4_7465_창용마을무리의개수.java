package D4;

import java.io.*;

public class D4_7465_창용마을무리의개수 {
	
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= TC; t++) {
			
			String[] splited = in.readLine().split(" ");
			int N = Integer.parseInt(splited[0]);
			int M = Integer.parseInt(splited[1]);
			parents = new int[N + 1];
			
			for(int i = 1; i <= N; i++) parents[i] = i;
			
			for(int i = 0; i < M; i++) {
				splited = in.readLine().split(" ");
				int set1 = Integer.parseInt(splited[0]);
				int set2 = Integer.parseInt(splited[1]);
				
				union(set1, set2);
			}
			
			boolean[] check = new boolean[N + 1];
			int ans = 0;
			for(int i = 1; i <= N; i++) {
				if(check[findSet(i)] == true) continue;
				check[findSet(i)] = true;
				ans++;
			}
			
			builder.append("#" + t + " " + ans + "\n");
		}
		System.out.println(builder);
	}
	
	public static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static void union(int a, int b) {	
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return;
		
		parents[bRoot] = aRoot;
	}

}
