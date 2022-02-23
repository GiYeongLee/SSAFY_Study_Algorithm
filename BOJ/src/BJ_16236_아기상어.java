import java.io.*;
import java.util.*;

public class BJ_16236_아기상어 {
	
	static class Shark{
		int x;
		int y;
		int size;	// 상어의 크기
		int eat;	// 상어가 먹은 횟수
		
		public Shark(int x, int y, int size, int eat) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.eat = eat;
		}
		
		public void checkSize() {	// 상어가 size만큼 먹으면 size를 바꿔주는 메서드
			if(this.eat == size) {
				this.size++;
				this.eat = 0;
			}
		}
	}
	
	static class Fish implements Comparable<Fish>{
		int x;
		int y;
		int size;
		int dist;
		
		public Fish(int x, int y, int size, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {	// 우선순위 : 1. 상어와의 거리 2. x좌표 3. y좌표
			if(this.dist == o.dist) {
				if(this.x == o.x) {
					return Integer.compare(this.y, o.y);
				}
				return Integer.compare(this.x, o.x);
			}
			return Integer.compare(this.dist, o.dist);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		int[] dx = {-1, 0, 0, 1};
		int[] dy = {0, -1, 1, 0};
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[][] grid = new int[N][N];
		int ans = 0;
		Shark shark = null;
		
		for(int i = 0; i < N; i++) {
			String[] splited = in.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(splited[j]);
				if(grid[i][j] == 9) {
					grid[i][j] = 0;		// 나중에 지나갈 수 있게 0으로 초기화
					shark = new Shark(i, j, 2, 0);	// 초기 위치, 크기 2 초기화
				}
			}
		}
		
		PriorityQueue<Fish> pq = new PriorityQueue<Fish>();	// 물고기 정보를 담을 우선순위큐 생성
		Queue<int[]> queue = new LinkedList<int[]>();	// bfs에 사용할 큐
		queue.offer(new int[] {shark.x, shark.y, 0});	// 큐에 상어 초기위치 추가
		
		while(true) {
			
			boolean[][] visited = new boolean[N][N];	// 방문했는지 확인할 boolean 배열
			
			while(!queue.isEmpty()) {	// 한 bfs 싸이클마다 모든 물고기 정보를 pq에 저장
				
				int curX = queue.peek()[0];
				int curY = queue.peek()[1];
				int dist = queue.poll()[2];
				visited[curX][curY] = true;
				
				for(int dir = 0; dir < 4; dir++) {
					
					int nextX = curX + dx[dir];
					int nextY = curY + dy[dir];
					
					// 범위 밖으로 벗어나면 continue
					if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
					// 더 큰 물고기를 만나거나 이미 방문했던 위치라면 continue
					if(grid[nextX][nextY] > shark.size || visited[nextX][nextY] == true) continue;
					// 작은 물고기를 만나면 pq에 물고기 정보 저장 ( 거리 +1해서 저장 )
					if(grid[nextX][nextY] < shark.size && grid[nextX][nextY] != 0) pq.offer(new Fish(nextX, nextY, grid[nextX][nextY], dist + 1));
					
					// 아무것도 해당되지 않으면 거리를 +1 해서 queue에 추가
					queue.offer(new int[] {nextX, nextY, dist + 1});
					// 방문 표시
					visited[nextX][nextY] = true;
					
				}
			}
			
			if(pq.isEmpty()) {	// pq가 비어있으면 다 먹은거임
				System.out.println(ans);
				break;
			}
			
			Fish fish = pq.poll();	// 우선순위가 제일 높은 물고기 꺼내기
			ans += fish.dist;	// 거리값을 정답에 추가
			grid[fish.x][fish.y] = 0;	// 해당 물고기 위치 0으로 바꾸기 
			queue.offer(new int[] {fish.x, fish.y, 0});	// 다음 초기값은 먹은 물고기의 위치
			pq.clear();	// pq 초기화
			
			shark.eat++;	// 상어가 먹은 횟수 +1
			shark.checkSize();	// 상어가 커져야하는지 검사
		}
	}
}
