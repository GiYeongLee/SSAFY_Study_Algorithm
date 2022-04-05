package SW;

import java.io.*;
import java.util.*;

public class SW_5656_벽돌깨기 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int N, W, H;
	static int[][] grid;
	static int[] permute;
	
	static int MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= TC; t++) {
			input();
			permutation(0);
			builder.append("#" + t + " " + MIN + "\n");
			MIN = Integer.MAX_VALUE;
		}
		
		builder.setLength(builder.length() - 1);
		System.out.println(builder.toString());
	}
	
	public static void input() throws IOException {
		String[] splited = in.readLine().split(" ");
		
		N = Integer.parseInt(splited[0]);
		W = Integer.parseInt(splited[1]);
		H = Integer.parseInt(splited[2]);
		permute = new int[N];
		grid = new int[H][W];
			
		for(int i = 0; i < H; i++) {
			splited = in.readLine().split(" ");
			for(int j = 0; j < W; j++) {
				grid[i][j] = Integer.parseInt(splited[j]);
			}
		}
	}
	
	public static void permutation(int count) {
		if(count == N) {
			func();
			return;
		}
		for(int i = 0; i < W; i++) {
			permute[count] = i;
			permutation(count + 1);
		}
	}
	
	public static void func() {	
		int[][] gridCopy = copyGrid(grid);
		
		for(int i = 0; i < N; i++) {
			
			int col = 0;;
			int row = permute[i];
			
			if(gridCopy[H - 1][row] == 0) continue;
			for(int k = 0; k < H; k++) {
				if(gridCopy[k][row] != 0) {
					col = k;
					break;
				}
			}
			
			deleteBlock(col, row, gridCopy);
			downBlock(gridCopy);
		}	
		MIN = Math.min(MIN, countBlock(gridCopy));
	}
	
	public static void deleteBlock(int col, int row, int[][] gridCopy) {	
		int num = gridCopy[col][row];	
		gridCopy[col][row] = 0;
		
		if(num == 1) return;
		
		for(int dir = 0; dir < 4; dir++) {
			int nextX = col;
			int nextY = row;
			for(int i = 0; i < num - 1; i++) {
				nextX += dx[dir];
				nextY += dy[dir];
				if(nextX < 0 || nextY < 0 || nextX >= H || nextY >= W) break;
				if(gridCopy[nextX][nextY] == 0) continue;
				if(gridCopy[nextX][nextY] == 1) gridCopy[nextX][nextY] = 0;
				else {
					deleteBlock(nextX, nextY, gridCopy);
				}
			}
		}	
	}
	
	public static void downBlock(int[][] gridCopy) {
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int j = 0; j < W; j++) {
			stack.clear();
			for(int i = 0; i < H; i++) {
				if(gridCopy[i][j] != 0) stack.push(gridCopy[i][j]);
				gridCopy[i][j] = 0;
			}
			
			for(int i = H - 1; i >= 0; i--) {
				if(stack.isEmpty()) break;
				gridCopy[i][j] = stack.pop();
			}
		}
	}
	
	public static int countBlock(int[][] gridCopy) {
		int count = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(gridCopy[i][j] != 0) count++;
			}
		}
		return count;
	}
	
	public static int[][] copyGrid(int[][] grid){
		int[][] temp = new int[H][W];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				temp[i][j] = grid[i][j];
			}
		}
		return temp;
	}
}
