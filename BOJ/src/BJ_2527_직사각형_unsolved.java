import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2527_직사각형_unsolved {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 4; t++) {
			int[] x = new int[4];
			int[] y = new int[4];
			
			String[] splited = in.readLine().split(" ");
			
			for(int i = 0; i < 4; i++) {
				x[i] = Integer.parseInt(splited[i * 2]);
				y[i] = Integer.parseInt(splited[i * 2 + 1]);
			}
			
			if(x[1] < x[2] || x[3] < x[0] || y[1] < y[2] || y[3] < y[0]) {
				System.out.println("d");
				continue;
			}
			
			if((x[1] == x[2] && y[1] == y[2]) || (x[0] == x[3] && y[1] == y[2]) || (x[1] == x[2] && y[0] == y[3]) || (x[0] == x[3] && y[0] == y[3])){
				System.out.println("c");
				continue;
			}
			
			if((x[1] == x[2] && y[1] != y[2]) || (x[0] == x[3] && y[1] != y[2]) || (x[1] != x[2] && y[0] == y[3]) || (x[0] != x[3] && y[0] == y[3])) {
				System.out.println("b");
				continue;
			}
			
			System.out.println("a");
		}		
	}
}
