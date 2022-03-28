import java.io.*;
import java.util.*;

public class BJ_13460_구슬탈출2 {

	static class Data{
		int redX, redY, blueX, blueY, count;

		public Data() {}

		public Data(int redX, int redY, int blueX, int blueY, int count) {
			this.redX = redX;
			this.redY = redY;
			this.blueX = blueX;
			this.blueY = blueY;
			this.count = count;
		}

	}

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	static int N, M;
	static char[][] grid;
	static int[][][][] visited = new int[10][10][10][10];

	static Queue<Data> queue = new LinkedList<Data>();

	public static int bfs() {
		visited[queue.peek().redX][queue.peek().redY][queue.peek().blueX][queue.peek().blueY] = 1;	// 시작 지점 방문 체크

		while(!queue.isEmpty()){
			Data cur = queue.poll();
			if(cur.count > 10) break;	// 10번을 초과했다면 break;
			if(grid[cur.redX][cur.redY] == 'O' && grid[cur.blueX][cur.blueY] != 'O'){	
				// 빨간 공이 구멍에 들어갔고, 파란 공이 구멍에 들어가지 않았다면 현재 count값을 반환
				return cur.count;
			}
			if(grid[cur.redX][cur.redY] != 'O' && grid[cur.blueX][cur.blueY] == 'O'){
				// 빨간 공이 구멍에 들어가지 않았는데, 파란 공이 구멍에 들어갔다면 해당 경우를 pass
				continue;
			}

			for(int dir = 0; dir < 4; dir++){
				// 현재 공의 위치를 next 변수에 저장
				int nextRedX = cur.redX;
				int nextRedY = cur.redY;
				int nextBlueX = cur.blueX;
				int nextBlueY = cur.blueY;
				// 빨간 공과 파란 공이 움직인 횟수를 저장할 변수
				int countRed = 0;
				int countBlue = 0;
				
				while(true){
					// 빨간 공 이동
					nextRedX += dx[dir];
					nextRedY += dy[dir];
					if(grid[nextRedX][nextRedY] != '#' && grid[nextRedX][nextRedY] != 'O'){
						// 이동한 위치가 벽 & 구멍이 아니면 continue
						countRed++;
						continue;
					}
					if(grid[nextRedX][nextRedY] == '#'){
						// 이동한 위치가 벽이면 한번 무르고 이동 종료
						nextRedX -= dx[dir];
						nextRedY -= dy[dir];
						break;
					} else if(grid[nextRedX][nextRedY] == 'O'){
						// 이동한 위치가 구멍이면 그대로 이동 종료
						break;
					}
				}

				while(true){
					// 파란 공 이동
					nextBlueX += dx[dir];
					nextBlueY += dy[dir];
					if(grid[nextBlueX][nextBlueY] != '#' && grid[nextBlueX][nextBlueY] != 'O'){
						// 이동한 위치가 벽 & 구멍이 아니면 continue
						countBlue++;
						continue;
					}
					if(grid[nextBlueX][nextBlueY] == '#'){
						// 이동한 위치가 벽이면 한번 무르고 이동 종료
						nextBlueX -= dx[dir];
						nextBlueY -= dy[dir];
						break;
					} else if(grid[nextBlueX][nextBlueY] == 'O'){
						// 이동한 위치가 구멍이면 그대로 이동 종료
						break;
					}
				}

				if(nextRedX == nextBlueX && nextRedY == nextBlueY){
					// 두 공 모두 이동이 종료되었지만 같은 위치에 있는 경우
					if(grid[nextRedX][nextRedY] != 'O'){
						// 두 공이 구멍이 아닌 곳에 함께 있는 경우 더 많이 움직인 공이 움직인 경로에서 뒤에 위치
						if(countRed > countBlue){
							nextRedX -= dx[dir];
							nextRedY -= dy[dir];
						} else{
							nextBlueX -= dx[dir];
							nextBlueY -= dy[dir];
						}
					} else{
						// 두 공이 구멍에 함께 있는 경우 해당 경우 pass
						continue;
					}
				}

				if(visited[nextRedX][nextRedY][nextBlueX][nextBlueY] == 0){
					// 두 공이 모두 방문한 적이 없는 경우의 수라면 방문 체크 후, queue에 추가
					visited[nextRedX][nextRedY][nextBlueX][nextBlueY] = 1;
					Data data = new Data(nextRedX, nextRedY, nextBlueX, nextBlueY, cur.count + 1);
					queue.add(data);
				}
			}
		}
		return -1;
	}

	public static void input() throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] splited = in.readLine().split(" ");

		int N = Integer.parseInt(splited[0]);
		int M = Integer.parseInt(splited[1]);
		grid = new char[N][M];
		Data data = new Data();

		for(int i = 0; i < N; i++){
			String temp = in.readLine();
			for(int j = 0; j < M; j++){
				grid[i][j] = temp.charAt(j);
				if(grid[i][j] == 'R') {
					data.redX = i;
					data.redY = j;
				} else if(grid[i][j] == 'B'){
					data.blueX = i;
					data.blueY = j;
				}
			}
		}
		data.count = 0;
		queue.add(data);

		return;
	}

	public static void main(String[] args) throws Exception{		
		input();
		System.out.println(bfs());		
	}	
}
