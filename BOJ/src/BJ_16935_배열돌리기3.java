import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16935_배열돌리기3 {
	
	static int[][] grid = new int[100][100];
	static int[][] gridTemp;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] splited = in.readLine().split(" ");	
		N = Integer.parseInt(splited[0]);
		M = Integer.parseInt(splited[1]);
		int R = Integer.parseInt(splited[2]);
		
		for(int i = 0; i < N; i++) {
			String[] temp = in.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		String[] temp = in.readLine().split(" ");
		for(int i = 0; i < R; i++) {
			gridTemp = new int[100][100];
			switch(Integer.parseInt(temp[i])) {
			case 1:
				upDown();
				break;
			case 2:
				leftRight();
				break;
			case 3:
				clock();
				break;
			case 4:
				clockReverse();
				break;
			case 5:
				func5();
				break;
			case 6:
				func6();
				break;
			}
		}
		print();
	}
	
	public static void upDown() {
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < M; j++) {
				int temp = grid[N - i - 1][j];
				grid[N - i - 1][j] = grid[i][j];
				grid[i][j] = temp;
			}
		}
	}
	
	public static void leftRight() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M / 2; j++) {
				int temp = grid[i][M - j - 1];
				grid[i][M - j - 1] = grid[i][j];
				grid[i][j] = temp;
			}
		}
	}
	
	public static void clock() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				gridTemp[j][N - i - 1] = grid[i][j];
			}
		}
		int temp = M;
		M = N;
		N = temp;
		grid = gridTemp.clone();
	}
	
	public static void clockReverse() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				gridTemp[M - j - 1][i] = grid[i][j];
			}
		}
		int temp = M;
		M = N;
		N = temp;
		grid = gridTemp.clone();
	}
	
	public static void func5() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if((i >= 0 && i < N / 2) && (j >= 0 && j < M / 2)) {
					gridTemp[i][j + (M / 2)] = grid[i][j];
				}
				if((i >= 0 && i < N / 2) && (j >= M / 2 && j < M)) {
					gridTemp[i + (N / 2)][j] = grid[i][j];
				}
				if((i >= N / 2 && i < N) && (j >= M / 2 && j < M)) {
					gridTemp[i][j - (M / 2)] = grid[i][j];
				}
				if((i >= N / 2 && i < N) && (j >= 0 && j < M / 2)) {
					gridTemp[i - (N / 2)][j] = grid[i][j];
				}
			}
		}
		grid = gridTemp.clone();
	}
	
	public static void func6() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if((i >= 0 && i < N / 2) && (j >= 0 && j < M / 2)) {
					gridTemp[i + (N / 2)][j] = grid[i][j];
				}
				if((i >= 0 && i < N / 2) && (j >= M / 2 && j < M)) {
					gridTemp[i][j - (M / 2)] = grid[i][j];
				}
				if((i >= N / 2 && i < N) && (j >= M / 2 && j < M)) {
					gridTemp[i - (N / 2)][j] = grid[i][j];
				}
				if((i >= N / 2 && i < N) && (j >= 0 && j < M / 2)) {
					gridTemp[i][j + (M / 2)] = grid[i][j];
				}
			}
		}
		grid = gridTemp.clone();
	}
	
	public static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
