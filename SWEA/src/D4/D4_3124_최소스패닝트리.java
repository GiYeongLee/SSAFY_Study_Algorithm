package D4;

import java.io.*;
import java.util.*;

public class D4_3124_최소스패닝트리 {
	
	static class Node implements Comparable<Node> {
		int idx;
		long weight;
		
		public Node(int idx, long weight) {
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.weight, o.weight);
		}	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= TC; t++) {
			
			String[] splited = in.readLine().split(" ");
			
			int V = Integer.parseInt(splited[0]);
			int E = Integer.parseInt(splited[1]);
			
			ArrayList<Node>[] list = new ArrayList[V];
			for(int i = 0; i < V; i++) {
				list[i] = new ArrayList<Node>();
			}
			
			boolean[] visited = new boolean[V];
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			pq.add(new Node(0, 0));
			
			for(int i = 0; i < E; i++) {
				splited = in.readLine().split(" ");
				int from = Integer.parseInt(splited[0]) - 1;
				int to = Integer.parseInt(splited[1]) - 1;
				long weight = Long.parseLong(splited[2]);
				list[from].add(new Node(to, weight));
				list[to].add(new Node(from, weight));
			}
			
			int count = 0;
			long answer = 0;
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if(visited[cur.idx]) continue;
				
				answer += cur.weight;
				visited[cur.idx] = true;
				count++;
				
				if(count == V) break;
				
				for(int i = 0; i < list[cur.idx].size(); i++) {
					Node next = list[cur.idx].get(i);
					if(visited[next.idx]) continue;
					pq.add(next);
				}	
			}			
			builder.append("#" + t + " " + answer + "\n");
		}
		System.out.println(builder.toString());
	}
}
