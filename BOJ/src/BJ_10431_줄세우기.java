import java.io.*;
import java.util.*;

public class BJ_10431_줄세우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int P = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= P; t++) {
			
			String[] splited = in.readLine().split(" ");
			
			int TC = Integer.parseInt(splited[0]);
			ArrayList<Integer> height = new ArrayList<Integer>();
			int max = Integer.parseInt(splited[1]);
			height.add(max);
			
			int count = 0;
			
			for(int i = 2; i <= 20; i++) {
				int next = Integer.parseInt(splited[i]);
				if(max <= next) {
					max = next;
					height.add(next);
				}
				else {
					for(int j = 0; j < height.size(); j++) {
						if(height.get(j) > next) {
							height.add(j, next);
							count += height.size() - j - 1;
							break;
						}
					}
				}
			}
			builder.append(TC + " " + count + "\n");
		}
		builder.setLength(builder.length() - 1);
		System.out.println(builder.toString());
	}
}
