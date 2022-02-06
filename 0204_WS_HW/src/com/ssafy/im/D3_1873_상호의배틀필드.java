package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1873_상호의배틀필드 {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int x = 0;
	static int y = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());

		for(int t = 1; t <= TC; t++) {
			
			String temp = in.readLine();
			String[] splited = temp.split(" ");
			int H = Integer.parseInt(splited[0]);
			int W = Integer.parseInt(splited[1]);
		
			char[][] map = new char[H][W];
			x = 0;
			y = 0;
			
			for(int i = 0; i < H; i++) {
				String temp2 = in.readLine();
				for(int j = 0; j < W; j++) {
					map[i][j] = temp2.charAt(j);
					if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						x = i;
						y = j;
					}
				}
			}
			
			int N = Integer.parseInt(in.readLine());
			String arr = in.readLine();
			char[] command = new char[N];
			
			for(int i = 0; i < N; i++) {
				command[i] = arr.charAt(i);
			}
			
			for(int i = 0; i < N; i++) {
				switch(command[i]) {
				case 'U':
					move('^', map, W, H);
					break;
				case 'D':
					move('v', map, W, H);
					break;
				case 'L':
					move('<', map, W, H);
					break;
				case 'R':
					move('>', map, W, H);
					break;
				case 'S':
					shoot(map[x][y], x, y, map, W, H);
					break;
				}
			}
			System.out.print("#" + t + " ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	static void move(char command, char[][] map, int W, int H) {
		int dir = 0;
		switch(command) {
		case '^':
			dir = 0;
			break;
		case 'v':
			dir = 1;
			break;
		case '<':
			dir = 2;
			break;
		case '>':
			dir = 3;
			break;
		}
		int cor_x = x + dx[dir];
		int cor_y = y + dy[dir];
		if(cor_x == H || cor_y == W || cor_x < 0 || cor_y < 0) {
			map[x][y] = command;
			return;
		}
		if(map[cor_x][cor_y] == '.') {
			map[x][y] =  '.';
			x = cor_x;
			y = cor_y;
			map[x][y] = command;
		}
		else {
			map[x][y] = command;
		}
	}
	
	static void shoot(char command, int x, int y, char[][] map, int W, int H) {
		int dir = 0;
		switch(command) {
		case '^':
			dir = 0;
			break;
		case 'v':
			dir = 1;
			break;
		case '<':
			dir = 2;
			break;
		case '>':
			dir = 3;
			break;
		}
		int cor_x = x;
		int cor_y = y;
		while(true) {
			cor_x = cor_x + dx[dir];
			cor_y = cor_y + dy[dir];
			switch(dir) {
			case 0:
				if(cor_x < 0) return;
				break;
			case 1:
				if(cor_x > H - 1) return;
				break;
			case 2:
				if(cor_y < 0) return;
				break;
			case 3:
				if(cor_y > W - 1) return;
				break;
			}
			if(map[cor_x][cor_y] == '*') {
				map[cor_x][cor_y] = '.';
				return;
			}
			else if(map[cor_x][cor_y] == '#') {
				return;
			}
		}
	}
}
