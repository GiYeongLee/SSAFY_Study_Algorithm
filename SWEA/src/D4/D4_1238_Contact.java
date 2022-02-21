package D4;

import java.io.*;
import java.util.*;

public class D4_1238_Contact {

	static int N, maxCurrent, maxCount;
	static StringBuilder builder = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken()) - 1;
			
			int[][] adjMatrix = new int[N][N];
			
			st = new StringTokenizer(in.readLine());
			while(st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				adjMatrix[from][to] = 1;
			}
			
			bfs(adjMatrix, start);
			builder.append("#" + t + " " + (maxCurrent + 1) + "\n");
		}	
		System.out.println(builder);
	}
	
	public static void bfs(int[][] adjMatrix, int start) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[] visited = new boolean[N];
		
		queue.offer(new int[] {start, 0});
		visited[start] = true;
		
		maxCurrent = 0;
		maxCount = 0;
		
		while(!queue.isEmpty()) {
			int current = queue.peek()[0];
			int count = queue.poll()[1];
			if(count > maxCount) {
				maxCount = count;
				maxCurrent = current;
			}
			else if(count == maxCount && current > maxCurrent) {
				maxCurrent = current;
			}
			
			// current 점정의 인접 정점 처리(단, 방문하지 않은 인접정점만)
			for(int j = 0; j < N; j++) {
				if(!visited[j] && adjMatrix[current][j] != 0) {	// 방문하지 않았고, current에서 갈수 있다면
					queue.offer(new int[] {j, count + 1});
					visited[j] = true;
				}
			}
		}	
	}
}
