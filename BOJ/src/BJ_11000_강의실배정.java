import java.io.*;
import java.util.*;

public class BJ_11000_강의실배정 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	static ArrayList<Lec> list = new ArrayList<Lec>();
	static int N;
	
	static class Lec implements Comparable<Lec>{
		int start;
		int end;
		
		public Lec(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lec o) {
			if(this.start == o.start) return this.end - o.end;
			else return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws Exception {
		input();
		func();
		System.out.println(pq.size());
	}
	
	public static void input() throws Exception{
		N = Integer.parseInt(in.readLine());
		for(int i = 0; i < N; i++) {
			String[] splited = in.readLine().split(" ");
			list.add(new Lec(Integer.parseInt(splited[0]), Integer.parseInt(splited[1])));
		}
		Collections.sort(list);
	}

	public static void func() {
		for(Lec lec : list) {
			if(!pq.isEmpty() && pq.peek() <= lec.start) pq.poll();
			pq.add(lec.end);
		}
	}
}
