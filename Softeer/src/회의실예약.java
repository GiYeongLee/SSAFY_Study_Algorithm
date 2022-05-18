import java.io.*;
import java.util.*;

public class 회의실예약 {
	
	public static void main(String[] args) throws IOException {
		print(input());
	}
	
	static SortedMap<String, boolean[]> input() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		int N = Integer.parseInt(splited[0]);
		int M = Integer.parseInt(splited[1]);
		
		SortedMap<String, boolean[]> map = new TreeMap<String, boolean[]>();
		
		for(int i = 0; i < N; i++) {
			map.put(in.readLine(), new boolean[9]);
		}
		
		for(int i = 0; i < M; i++) {
			splited = in.readLine().split(" ");
			boolean[] temp;
			temp = map.get(splited[0]);
			
			int start = Integer.parseInt(splited[1]);
			int end = Integer.parseInt(splited[2]);
			
			for(int j = start - 9; j < end - 9; j++) {
				temp[j] = true;
			}		
			map.put(splited[0], temp);
		}
		return map;
	}
	
	static void print(SortedMap<String, boolean[]> map) {	
		StringBuilder mainBuilder = new StringBuilder();
		
		for(String key : map.keySet()) {
			StringBuilder timeBuilder = new StringBuilder();
			mainBuilder.append("Room " + key + ":\n");
			
			int count = 0;
			boolean flag = true;
			boolean[] temp = map.get(key);
			
			for(int i = 9; i < 18; i++) {
				if(flag && !temp[i - 9]) {
					count++;
					flag = false;
					if(i == 9) timeBuilder.append("0");
					timeBuilder.append(i + "-");
				}
				if(!flag && temp[i - 9]) {
					flag = true;
					timeBuilder.append(i + "\n");
				}
			}
			if(!flag) timeBuilder.append(18 + "\n");
			
			if(count == 0) mainBuilder.append("Not available\n");
			else mainBuilder.append(count + " available:\n");
			
			mainBuilder.append(timeBuilder.toString());
			mainBuilder.append("-----\n");
		}
		mainBuilder.setLength(mainBuilder.length() - 6);
		System.out.println(mainBuilder.toString());
	}
}
