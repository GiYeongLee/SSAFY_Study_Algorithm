package D4;

import java.util.*;
import java.io.*;

public class D4_3289_서로소집합 {
	
	static int n, m;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= TC; t++) {
			
			builder.append("#" + t + " ");
			
			String[] splited = in.readLine().split(" ");
			n = Integer.parseInt(splited[0]);
			m = Integer.parseInt(splited[1]);
			
			parents = new int[n + 1];
			
			for(int i = 1; i <= n; i++) {
				parents[i] = i;
			}
			
			for(int i = 0; i < m; i++) {
				
				splited = in.readLine().split(" ");
				int command = Integer.parseInt(splited[0]);
				int set1 = Integer.parseInt(splited[1]);
				int set2 = Integer.parseInt(splited[2]);
			
				switch(command) {
				case 0:
					union(set1, set2);
					break;
				case 1:
					if(!isSame(set1, set2)) builder.append("1");
					else builder.append("0");
					break;
				}
			}
			builder.append("\n");
		}
		System.out.println(builder);
	}
	
	public static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);	// Path Compression
	}
	
	public static void union(int a, int b) {
		if(isSame(a, b)) {
			int aRoot = findSet(a);
			int bRoot = findSet(b);
			parents[bRoot] = aRoot;
		}
	}
	
	public static boolean isSame(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		else return true;
	}
	
}
