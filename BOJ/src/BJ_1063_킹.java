import java.io.*;

public class BJ_1063_킹 {
	
	static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
	static int[] dy = {0, 0, 1, -1, -1, -1, 1, 1};
	
	static int kingX;
	static int kingY;
	static int rockX;
	static int rockY;
	
	static void move(int idx) {
		int kingNextX = kingX + dx[idx];
		int kingNextY = kingY + dy[idx];
		int rockNextX = rockX + dx[idx];
		int rockNextY = rockY + dy[idx];
		
		if(kingNextX == rockX && kingNextY == rockY) {
			if(rockNextX >= 0 && rockNextY >= 0 && rockNextX < 8 && rockNextY < 8) {
				kingX = kingNextX;
				kingY = kingNextY;
				rockX = rockNextX;
				rockY = rockNextY;
				return;
			}
		}
		else {
			if(kingNextX >= 0 && kingNextY >= 0 && kingNextX < 8 && kingNextY < 8) {
				kingX = kingNextX;
				kingY = kingNextY;
				return;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		String[] splited = in.readLine().split(" ");
		
		kingX = splited[0].charAt(0) - 'A';
		kingY = 8 - (splited[0].charAt(1) - '0');
		
		rockX = splited[1].charAt(0) - 'A';
		rockY = 8 - (splited[1].charAt(1) - '0');
		
		int N = Integer.parseInt(splited[2]);
		
		for(int t = 0; t < N; t++) {
			
			String cmd = in.readLine();			
			switch(cmd) {
			case "R":
				move(0);
				break;
			case "L":
				move(1);
				break;
			case "B":
				move(2);
				break;
			case "T":
				move(3);
				break;
			case "RT":
				move(4);
				break;
			case "LT":
				move(5);
				break;
			case "RB":
				move(6);
				break;
			case "LB":
				move(7);
				break;
			}
		}
		builder.append((char)(kingX + 'A'));
		builder.append(8 - kingY);
		builder.append("\n");
		builder.append((char)(rockX + 'A'));
		builder.append(8 - rockY);
		
		System.out.println(builder.toString());
	}

}
