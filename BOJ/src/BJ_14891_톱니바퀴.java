import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_14891_톱니바퀴 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(calc());
	}
	
	static int K;
	static int[][] arr;
	static Queue<int[]> queue;
	static boolean[] visited;
	static int[] score = {1, 2, 4, 8};

	static void input() throws NumberFormatException, IOException {
		arr = new int[4][8];
		for(int i = 0; i < 4; i++) {
			String temp = in.readLine();
			for(int j = 0; j < 8; j++) {
				arr[i][j] = temp.charAt(j) - '0';	// 화살표부터 시계방향
			}
		}
		K = Integer.parseInt(in.readLine());
		for(int i = 0; i < K; i++) {
			String[] splited = in.readLine().split(" ");
			int start = Integer.parseInt(splited[0]) - 1;
			int dir = Integer.parseInt(splited[1]);		// 1 : 시계방향, -1 : 반시계방향
			queue = new LinkedList<int[]>();
			queue.add(new int[] {start, dir});
			visited = new boolean[4];
			visited[start] = true;
			check();
		}
	}
	
	static void check() {
		while(!queue.isEmpty()){		
			int target = queue.peek()[0];
			int direction = queue.poll()[1];
			
			// 맨 왼쪽 제외하고 왼쪽 확인(현재 6번 & 다음 2번)
			if(target > 0 && arr[target][6] != arr[target - 1][2] && !visited[target - 1]) {
				visited[target - 1] = true;
				queue.add(new int[] {target - 1, direction * (-1)});
			} 
			// 맨 오른쪽 제외하고 오른쪽 확인(현재 2번 & 다음 6번)
			if(target < 3 && arr[target][2] != arr[target + 1][6] && !visited[target + 1]) {
				visited[target + 1] = true;
				queue.add(new int[] {target + 1, direction * (-1)});
			}		
			rotate(target, direction);
		}
	}
	
	static void rotate(int target, int direction) {
		int temp;
		switch(direction) {
		case 1:
			temp = arr[target][7];
			for(int i = 7; i > 0; i--) {
				arr[target][i] = arr[target][i - 1];
			}
			arr[target][0] = temp;
			break;
		case -1:
			temp = arr[target][0];
			for(int i = 0; i < 7; i++) {
				arr[target][i] = arr[target][i + 1];
			}
			arr[target][7] = temp;
			break;
		}
	}

	static int calc() {
		int result = 0;
		for(int i = 0; i < 4; i++) {
			if(arr[i][0] == 1) result += score[i];
		}
		return result;
	}
}
