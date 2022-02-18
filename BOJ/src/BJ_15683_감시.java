import java.io.*;
import java.util.*;

public class BJ_15683_감시 {
	
	static class CCTV{
		int x;
		int y;
		int id;
		
		CCTV(int x, int y, int id) {
			this.x = x;
			this.y = y;
			this.id = id;
		}
	}
	
	static int N, M;
	static int[][] grid;
	static int[][] gridTemp;
	static int[] direction;
	static ArrayList<CCTV> cctv = new ArrayList<CCTV>();
	static int[] dx = {-1, 0, 1, 0};	// 상, 우, 하, 좌 (시계방향)
	static int[] dy = {0, 1, 0, -1};
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if(grid[i][j] >=1 && grid[i][j] <= 5) {
					cctv.add(new CCTV(i, j, grid[i][j]));
				}
			}
		}
		
		direction = new int[cctv.size()];
		make(0);
		
		System.out.println(min);
	}
	
	public static void make(int cnt) {	// CCTV마다 방향에 대해 모든 경우의 수 생성
		if(cnt == cctv.size()) {
			gridTemp = new int[N][M];	// 마킹할 배열 복제
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					gridTemp[i][j] = grid[i][j];
				}
			}
			
			for(int i = 0; i < cctv.size(); i++) {	// CCTV마다 생성된 방향 경우의 수에 따라 복제된 배열에 마킹
				CCTV cctvTemp = cctv.get(i);
				watch(cctvTemp.id, cctvTemp.x, cctvTemp.y, direction[i]);
			}
			
			int count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(gridTemp[i][j] == 0) {
						count++;
					}
				}
			}
			
			if(count < min) {
				min = count;
			}
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			direction[cnt] = i;
			make(cnt + 1);
		}
	}
	
	public static void watch(int id, int x, int y, int direction) {
		switch(id) {
		case 1:	// 1번 카메라
			switch(direction) {
			case 0:	// 상
				mark(x, y, 0);
				break;
			case 1:	// 좌
				mark(x, y, 1);
				break;
			case 2:	// 하
				mark(x, y, 2);
				break;
			case 3:	// 우
				mark(x, y, 3);
				break;
			}
			break;
		case 2:	// 2번 카메라
			switch(direction) {
			case 0:
			case 2:
				mark(x, y, 0);
				mark(x, y, 2);
				break;
			case 1:
			case 3:
				mark(x, y, 1);
				mark(x, y, 3);
				break;
			}
			break;
		case 3:	// 3번 카메라
			switch(direction) {
			case 0:
				mark(x, y, 0);
				mark(x, y, 1);
				break;
			case 1:
				mark(x, y, 1);
				mark(x, y, 2);
				break;
			case 2:
				mark(x, y, 2);
				mark(x, y, 3);
				break;
			case 3:
				mark(x, y, 3);
				mark(x, y, 0);
				break;
			}
			break;
		case 4:	// 4번 카메라
			switch(direction) {
			case 0:
				mark(x, y, 0);
				mark(x, y, 1);
				mark(x, y, 2);
				break;
			case 1:
				mark(x, y, 1);
				mark(x, y, 2);
				mark(x, y, 3);
				break;
			case 2:
				mark(x, y, 2);
				mark(x, y, 3);
				mark(x, y, 0);
				break;
			case 3:
				mark(x, y, 3);
				mark(x, y, 0);
				mark(x, y, 1);
				break;
			}
			break;
		case 5:	// 5번 카메라
			mark(x, y, 0);
			mark(x, y, 1);
			mark(x, y, 2);
			mark(x, y, 3);
			break;
		}
	}
	
	public static void mark(int x, int y, int dir) {	// 마킹	
		while(true) {
			x += dx[dir];
			y += dy[dir];
			if(x < 0 || y < 0 || x >= N || y >= M || gridTemp[x][y] == 6) break;
			if(gridTemp[x][y] >= 1 && gridTemp[x][y] <= 5) continue;
			gridTemp[x][y] = 7;
		}
	}

}
