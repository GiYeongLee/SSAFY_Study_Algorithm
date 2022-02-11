import java.util.*;
import java.io.*;


public class BJ_10158_개미_timeout {

	public static void main(String[] args) throws IOException {
		
		int[] dx = {1, 1, -1, -1};
		int[] dy = {1, -1, -1, 1};
				
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		int w = Integer.parseInt(splited[0]);
		int h = Integer.parseInt(splited[1]);
		
		splited = in.readLine().split(" ");
		int p = Integer.parseInt(splited[0]);
		int q = Integer.parseInt(splited[1]);
		long t = Integer.parseInt(in.readLine());
		
		int dir = 0;
		
		for(int i = 0; i < t; i++) {
			int nextX = q + dx[dir];
			int nextY = p + dy[dir];
			
			if(nextX == 0 && nextY == 0) {
				dir = 0;
				q = nextX; p = nextY;
				continue;
			}
			if(nextY == w && nextX == h) {
				dir = 2;
				q = nextX; p = nextY;
				continue;
			}
			if(nextY == 0 && nextX == h) {
				dir = 1;
				q = nextX; p = nextY;
				continue;
			}
			if(nextY == w && nextX == 0) {
				dir = 3;
				q = nextX; p = nextY;
				continue;
			}
			
			if(nextY == w) {
				if(dir == 0) dir = 1;
				if(dir == 3) dir = 2;
				q = nextX; p = nextY;
				continue;
			}
			if(nextY == 0) {
				if(dir == 2) dir = 3;
				if(dir == 1) dir = 0;
				q = nextX; p = nextY;
				continue;
			}
			if(nextX == h) {
				if(dir == 0) dir = 3;
				if(dir == 1) dir = 2;
				q = nextX; p = nextY;
				continue;
			}
			if(nextX == 0) {
				if(dir == 3) dir = 0;
				if(dir == 2) dir = 1;
				q = nextX; p = nextY;
				continue;
			}
			q = nextX; p = nextY;
		}
		System.out.println(p + " " + q);
	}

}
