import java.util.*;
import java.io.*;

public class BJ_1260_DFS와BFS {
	
	static int N, M, V;
	static StringBuilder builder = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] splited = in.readLine().split(" ");
		
		N = Integer.parseInt(splited[0]);
		M = Integer.parseInt(splited[1]);
		V = Integer.parseInt(splited[2]);
		
		int[][] adjMatrix = new int[N][N];	// 정점 수 크기로 생성
		
		for(int i = 0; i < M; i++) {
			splited = in.readLine().split(" ");
			int from = Integer.parseInt(splited[0]) - 1;
			int to = Integer.parseInt(splited[1]) - 1;
			// 무향이기 때문에 간선 하나로 양방향 모두 처리
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}
		
		dfs(adjMatrix, new boolean[N], V - 1);
		System.out.println();
		bfs(adjMatrix, new boolean[N], V - 1);
	}
	
	public static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
		visited[current] = true;
		System.out.print(current + 1 + " ");
		
		// current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
		for(int j = 0; j < N; j++) {
			if(!visited[j] && adjMatrix[current][j] != 0) {
				dfs(adjMatrix, visited, j);
			}
		}
	}
	
	public static void bfs(int[][] adjMatrix, boolean[] visited, int start) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + 1 + " ");
			
			// current 점정의 인접 정점 처리(단, 방문하지 않은 인접정점만)
			for(int j = 0; j < N; j++) {
				if(!visited[j] && adjMatrix[current][j] != 0) {	// 방문하지 않았고, current에서 갈수 있다면
					queue.offer(j);
					visited[j] = true;
				}
			}
		}
		
	}
}
