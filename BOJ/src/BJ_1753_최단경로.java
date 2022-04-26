import java.io.*;
import java.util.*;

public class BJ_1753_최단경로 {
	
	static class Node implements Comparable<Node>{
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);	// 오름차순 정렬
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		String[] splited = in.readLine().split(" ");
		
		int V = Integer.parseInt(splited[0]);	// 정점의 개수
		int E = Integer.parseInt(splited[1]);	// 간선의 개수
		
		int start = Integer.parseInt(in.readLine());
		
		ArrayList<Node>[] adj = new ArrayList[V + 1];
		for(int i = 1; i <= V; i++) adj[i] = new ArrayList<Node>();
		
		for(int i = 0; i < E; i++) {
			splited = in.readLine().split(" ");
			int from = Integer.parseInt(splited[0]);
			int to = Integer.parseInt(splited[1]);
			int weight = Integer.parseInt(splited[2]);
			adj[from].add(new Node(to, weight));
		}
		
		int[] distance = new int[V + 1];	// 출발에서 자신으로 오는 최소 비용
		boolean[] visited = new boolean[V + 1];	// 최소 비용이 결정됬는지 확인
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;	// 시작점의 최소 비용을 0으로 초기화	
	
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			
			Node temp = pq.poll();

			if(visited[temp.to]) continue;
			
			visited[temp.to] = true;
			
			for(Node n : adj[temp.to]) {
				if(distance[n.to] > distance[temp.to] + n.weight) {
					distance[n.to] = distance[temp.to] + n.weight;
					pq.add(new Node(n.to, distance[n.to]));
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(distance[i] != Integer.MAX_VALUE) builder.append(distance[i] + "\n");
			else builder.append("INF\n");
		}
		System.out.println(builder);
	}
}
