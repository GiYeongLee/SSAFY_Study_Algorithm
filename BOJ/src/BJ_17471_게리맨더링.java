import java.io.*;
import java.util.*;

public class BJ_17471_게리맨더링 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;	// 구역 수
	static int[] population;	// 인구 수
	static boolean[][] matrix;	// 인접 행렬
	
	static int[] arrA;	// A 선거구
	static int[] arrB;	// B 선거구
	static int totalPopulation;	// 전체 인구 수
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		func();
		if(answer != Integer.MAX_VALUE) System.out.println(answer);
		else System.out.println(-1);
	}
	
	// 입력
	static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(in.readLine());
		population = new int[N];
		matrix = new boolean[N][N];
		
		String[] splited = in.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(splited[i]);
			totalPopulation += population[i];
		}
		
		for(int i = 0; i < N; i++) {
			splited = in.readLine().split(" ");
			for(int j = 0; j < Integer.parseInt(splited[0]); j++) {
				int linked = Integer.parseInt(splited[j + 1]) - 1;
				matrix[i][linked] = true;
				matrix[linked][i] = true;
			}
		}
	}
	
	static void func() {
		// i : A 선거구에 들어갈 구역 수
		// N - 1 : B 선거구에 들어갈 구역 수 (전체 구역 수 - A 선거구 구역 수)
		for(int i = 1; i <= N / 2; i++) {
			arrA = new int[i];
			arrB = new int[N - i];
			combination(0, i, 0);
		}
	}
	
	// 조합
	static void combination(int count, int num, int start) {	
		// num : 선거구에 들어갈 구역 수
		if(count == num) {
			check(num);
			return;
		}
		
		for(int i = start; i < N; i++) {
			arrA[count] = i;
			combination(count + 1, num, i + 1);
		}
	}
	
	static void check(int num) {
		int sumA = 0;	// A 선거구 인구 수
		int sumB = 0;	// B 선거구 인구 수
		
		// 조합으로 생성된 A 선거구 배열 이용해서 B 선거구 배열 생성
		boolean[] check = new boolean[N];
		for(int i = 0; i < num; i++) {
			check[arrA[i]] = true;
			sumA += population[arrA[i]];
		}		
		int idx = 0;
		for(int i = 0; i < N; i++) {
			if(!check[i]) arrB[idx++] = i;
		}
		sumB = totalPopulation - sumA;
		
		// 연결 확인(BFS)
		if(!bfs(arrA)) return;
		if(!bfs(arrB)) return;

		answer = Math.min(answer, Math.abs(sumA - sumB));	
	}
	
	static boolean bfs(int[] arr) {
		boolean[] visited = new boolean[N];	// 방문 확인 배열
		
		// 다른 선거구 : false, 현재 선거구 : true
		for(int i = 0; i < arr.length; i++) {
			visited[arr[i]] = true;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();		
		queue.add(arr[0]);
		visited[arr[0]] = false;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i = 0; i < N; i++) {
				if(i == cur) continue;
				// 인접해있지 않거나, 다른 선거구의 구역 또는 이미 방문한 현재 선거구 구역일 경우 continue
				if(!matrix[cur][i] || !visited[i]) continue;
				
				visited[i] = false;	// 방문 체크
				queue.add(i);
			}
		}
		
		// 방문이 확인되지 않은 지역이 있을 경우 연결되어있지 않음
		for(int i = 0; i < N; i++) {
			if(visited[i]) return false;
		}	
		return true;
	}
}
