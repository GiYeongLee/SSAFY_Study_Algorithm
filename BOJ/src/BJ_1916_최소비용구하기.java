import java.io.*;
import java.util.*;

public class BJ_1916_최소비용구하기 {
	
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder builder = new StringBuilder();
	
	static int N, M;
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
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		visited = new boolean[N + 1];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < M; i++) {
			String[] splited = in.readLine().split(" ");
			int from = Integer.parseInt(splited[0]);
			int to = Integer.parseInt(splited[1]);
			int weight = Integer.parseInt(splited[2]);
			list.get(from).add(new Node(to, weight));
		}
		
		String[] splited = in.readLine().split(" ");
		dijkstra(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]));
	}
	
	static void dijkstra(int start, int end) {
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
		builder.append(distance[end]);
	}
}
