import java.io.*;
import java.util.*;

public class BJ_1504_특정한최단경로 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();
	
	static int max = 200000000;
	static int N, E;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
	
	static class Node implements Comparable<Node>{
		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) { return this.weight - o.weight; }
	}
	
	public static void main(String[] args) throws Exception {
		input();
		System.out.println(builder.toString());
	}
	
	static void input() throws Exception {
		String[] splited = in.readLine().split(" ");
		N = Integer.parseInt(splited[0]);
		E = Integer.parseInt(splited[1]);
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < E; i++) {
			splited = in.readLine().split(" ");
			int from = Integer.parseInt(splited[0]);
			int to = Integer.parseInt(splited[1]);
			int weight = Integer.parseInt(splited[2]);
			list.get(from).add(new Node(to, weight));
			list.get(to).add(new Node(from, weight));
		}
		
		splited = in.readLine().split(" ");
		int v1 = Integer.parseInt(splited[0]);
		int v2 = Integer.parseInt(splited[1]);
		
		long d1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
		long d2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
		
		if(d1 >= max && d2 >= max) builder.append(-1);
		else builder.append(Math.min(d1, d2));
	}
	
	static int dijkstra(int start, int end) {
		Arrays.fill(distance, max);
		Arrays.fill(visited, false);
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0));
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			int cur = pq.poll().to;		
			
			if(visited[cur]) continue;
			
			visited[cur] = true;		
			for(Node node : list.get(cur)) {
				if(!visited[node.to] && distance[node.to] > distance[cur] + node.weight) {
					distance[node.to] = distance[cur] + node.weight;
					pq.add(new Node(node.to, distance[node.to]));
				}
			}
		}
		return distance[end];
	}
}
