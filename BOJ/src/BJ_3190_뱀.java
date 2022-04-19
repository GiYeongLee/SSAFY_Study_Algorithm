import java.io.*;
import java.util.*;

public class BJ_3190_뱀 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	// 우, 하, 좌, 상
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	// dir : 방향, time : 시간, headX & headY : 현재 머리 위치
	static int N, K, L, dir, time, headX, headY;
	static int[][] grid;
	static Queue<int[]> snake = new LinkedList<int[]>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		func(Integer.MAX_VALUE, 'X');	// 입력된 값들을 모두 처리한 후, 방향 회전 없이 종료될때까지 수행
	}
	
	static void input() throws NumberFormatException, IOException {
		dir = time = headX = headY = 0;
		snake.add(new int[] {0, 0});	// queue에 초기 위치 저장
		
		N = Integer.parseInt(in.readLine());
		grid = new int[N][N];
		grid[0][0] = 2;		// 뱀이 있는 위치는 2로 표시
		
		K = Integer.parseInt(in.readLine());
		for(int i = 0; i < K; i++) {
			String[] splited = in.readLine().split(" ");
			int x = Integer.parseInt(splited[0]) - 1;
			int y = Integer.parseInt(splited[1]) - 1;
			grid[x][y] = 1;		// 사과가 있는 위치는 1로 표시
		}
		
		L = Integer.parseInt(in.readLine());
		for(int i = 0; i < L; i++) {
			String[] splited = in.readLine().split(" ");
			int t = Integer.parseInt(splited[0]);
			char direction = splited[1].charAt(0);
			func(t, direction);
		}
	}
	
	static void func(int t, char direction) {
		while(time != t) {	// 입력된 시간 전까지 이동
			time++;
			int nextX = headX + dx[dir];	// 이동할 위치
			int nextY = headY + dy[dir];
			
			// 범위를 벗어나거나 자기 몸과 부딪힐 경우 time 출력 후 종료
			if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || grid[nextX][nextY] == 2) {
				System.out.println(time);
				System.exit(0);
			}
			
			snake.add(new int[] {nextX, nextY});	// queue에 새로운 머리 위치 추가
			headX = nextX;
			headY = nextY;
			
			if(grid[nextX][nextY] != 1) {	// 사과를 먹은 경우가 아니라면 queue와 grid에서 꼬리부분 삭제
				int deleteX = snake.peek()[0];
				int deleteY = snake.poll()[1];
				grid[deleteX][deleteY] = 0;
			} 
			
			grid[nextX][nextY] = 2;	// grid에 머리 표시
		}
		
		switch(direction) {	// 방향 회전
		case 'L':
			dir--;
			if(dir == -1) dir = 3;
			break;
		case 'D':
			dir++;
			if(dir == 4) dir = 0;
			break;
		}
	}
}
