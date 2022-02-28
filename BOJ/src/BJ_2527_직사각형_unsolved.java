import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2527_직사각형_unsolved {
	
	static class Data implements Comparable<Data>{
		int x1;
		int y1;
		int x2;
		int y2;
		
		public Data(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		@Override
		public int compareTo(Data o) {
			return this.x1 - o.x1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		for(int t = 1; t <= 4; t++) {
			Data[] data = new Data[2];
			
			String[] splited = in.readLine().split(" ");
			
			data[0] = new Data(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]), Integer.parseInt(splited[2]), Integer.parseInt(splited[3]));
			data[1] = new Data(Integer.parseInt(splited[4]), Integer.parseInt(splited[5]), Integer.parseInt(splited[6]), Integer.parseInt(splited[7]));
			
			Arrays.sort(data);
			
			if(data[0].x1 == data[1].x1 && data[0].y1 == data[1].y1) {
				builder.append("a\n");
				continue;
			}
			
			if(data[0].x2 == data[1].x1 && data[0].y2 == data[1].y1) {	// 우상 점
				builder.append("c\n");
				continue;
			}
			
			if(data[0].x2 == data[1].x1 && data[0].y1 == data[1].y1) {	// 우하 점
				builder.append("c\n");
				continue;
			}
			
			if(data[0].x2 < data[1].x1 || data[0].y2 < data[1].y1 || data[0].y1 > data[1].y2) {
				builder.append("d\n");
				continue;
			}
			
			if(data[0].x2 == data[1].x1 || data[1].y2 == data[1].y1 || data[0].y1 == data[1].y2) {
				builder.append("b\n");
				continue;
			}
			
			builder.append("a\n");
		}
		builder.setLength(builder.length() - 1);
		System.out.println(builder.toString());
	}
}
