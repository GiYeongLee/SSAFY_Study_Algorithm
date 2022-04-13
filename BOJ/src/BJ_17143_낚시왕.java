import java.io.*;
import java.util.*;

public class BJ_17143_낚시왕 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	static class Shark{
		int r;	// 위치 x
		int c;	// 위치 y
		int s;	// 속력
		int d;	// 이동방향
		int z;	// 크기
		
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		public void move() {
			for(int i = 0; i < s; i++) {
				int nextX = this.r + dx[this.d];
				int nextY = this.c + dy[this.d];
				
				if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) {
					switch(this.d) {
					case 0:
						this.d = 1;
						break;
					case 1:
						this.d = 0;
						break;
					case 2:
						this.d = 3;
						break;
					case 3:
						this.d = 2;
						break;
					}
					i--;
					continue;
				}
				
				this.r = nextX;
				this.c = nextY;
			}
			if(temp[this.r][this.c] != null && temp[this.r][this.c].z > this.z) return;
			temp[this.r][this.c] = this;
		}
	}
	
	// 위, 아래, 오른쪽, 왼쪽
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	static int R, C, M;
	static Shark[][] grid;
	static Shark[][] temp;
	static ArrayList<Shark> list = new ArrayList<Shark>();
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		input();
		func();
		System.out.println(answer);
	}
	
	static void input() throws IOException {
		String[] splited = in.readLine().split(" ");
		R = Integer.parseInt(splited[0]);
		C = Integer.parseInt(splited[1]);
		M = Integer.parseInt(splited[2]);
		grid = new Shark[R][C];
		
		for(int k = 0; k < M; k++) {
			splited = in.readLine().split(" ");
			int r = Integer.parseInt(splited[0]) - 1;
			int c = Integer.parseInt(splited[1]) - 1;
			int s = Integer.parseInt(splited[2]);
			int d = Integer.parseInt(splited[3]) - 1;
			int z = Integer.parseInt(splited[4]);
			Shark shark = new Shark(r, c, s, d, z);
			list.add(shark);
			grid[r][c] = shark;
		}
	}

	static void func() {
		for(int i = 0; i < C; i++) {
			catching(i);
			move();
		}
	}
	
	static void catching(int col) {
		for(int i = 0; i < R; i++) {
			if(grid[i][col] != null) {
				answer += grid[i][col].z;
				grid[i][col] = null;
				return;
			}
		}
	}
	
	static void move() {
		temp = new Shark[R][C];
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(grid[i][j] == null) continue;
				grid[i][j].move();
			}
		}
		
		grid = copy(temp);
	}
	
	static Shark[][] copy(Shark[][] temp)
	{
		Shark[][] copy = new Shark[R][C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				copy[i][j] = temp[i][j];
			}
		}
		return copy;
	}
}





































