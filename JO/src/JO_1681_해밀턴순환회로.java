import java.io.*;

public class JO_1681_해밀턴순환회로 {
	
	static int min = Integer.MAX_VALUE;
	static int N;
	static int[][] adjMatrix;
	static int[] distance;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		input();
		dfs(1, 0, 0);
		
		System.out.println(min);
		
	}
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		adjMatrix = new int[N][N];
		distance = new int[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			String[] splited = in.readLine().split(" ");

			for(int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(splited[j]);
			}
		}
		
		visited[0] = true;
	}
	
	static void dfs(int cnt, int row, int sum) {
		
		if(cnt == N) {
			if(adjMatrix[row][0] == 0) return;	// 회사로 못돌아감
			if(sum + adjMatrix[row][0] < min) {
				min = sum + adjMatrix[row][0];
			}
			return;
		}
		
		if(sum > min) return;	// 가지치기
		
		for(int i = 0; i < N; i++) {
			if(adjMatrix[row][i] <= 0 || visited[i] == true) continue;
			
			visited[i] = true;
			dfs(cnt + 1, i, sum + adjMatrix[row][i]);
			visited[i] = false;
		}
	}
	
}
