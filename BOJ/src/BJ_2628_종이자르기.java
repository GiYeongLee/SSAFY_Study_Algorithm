import java.util.*;
import java.io.*;

public class BJ_2628_종이자르기 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		
		int Y = Integer.parseInt(splited[0]);
		int X = Integer.parseInt(splited[1]);
		
		int TC = Integer.parseInt(in.readLine());
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		
		for(int t = 0; t < TC; t++) {
			splited = in.readLine().split(" ");
			switch(Integer.parseInt(splited[0])) {
			case 0:
				x.add(Integer.parseInt(splited[1]));
				break;
			case 1:
				y.add(Integer.parseInt(splited[1]));
				break;
			}
		}
		
		Collections.sort(x);
		Collections.sort(y);
		
		int xSum = 0;
		int ySum = 0;
		
		for(int i = 0; i < x.size(); i++) {
			x.set(i, x.get(i) - xSum);
			xSum += x.get(i);
		}
		x.add(X - xSum);
		
		for(int i = 0; i < y.size(); i++) {
			y.set(i, y.get(i) - ySum);
			ySum += y.get(i);
		}
		y.add(Y - ySum);
		
		Collections.sort(x);
		Collections.sort(y);
		
		System.out.println(x.get(x.size() - 1) * y.get(y.size() - 1));
	}
}

