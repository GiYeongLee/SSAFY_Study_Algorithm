import java.util.*;
import java.io.*;

public class BJ_15686_치킨배달 {
	
	static int N, M;
	static ArrayList<int[]> house;
	static ArrayList<int[]> store;
	static int[] storeIdx;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		
		N = Integer.parseInt(splited[0]);
		M = Integer.parseInt(splited[1]);
		
		house = new ArrayList<int[]>();
		store = new ArrayList<int[]>();
		
		for(int i = 0; i < N; i++) {
			splited = in.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				int temp = Integer.parseInt(splited[j]);
				switch(temp) {
				case 1:
					house.add(new int[] {i, j});
					break;
				case 2:
					store.add(new int[] {i, j});
					break;
				}
			}
		}
		
		storeIdx = new int[M];
		
		combination(0, 0);
		
		System.out.println(min);

	}
	
	static void combination(int cnt, int idx) {
		if(cnt == M) {
			func(storeIdx);
			return;
		}
		
		for(int i = idx; i < store.size(); i++) {		
			storeIdx[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
	
	static void func(int[] storeIdx) {
		int sum = 0;
		for(int i = 0; i < house.size(); i++) {
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			for(int j = 0; j < storeIdx.length; j++) {
				pq.add(Math.abs(house.get(i)[0] - store.get(storeIdx[j])[0]) + Math.abs(house.get(i)[1] - store.get(storeIdx[j])[1]));
			}
			sum += pq.poll();
		}
		
		if(sum < min) min = sum;
	}

}
