import java.io.*;

public class BJ_10158_개미 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		int w = Integer.parseInt(splited[0]);
		int h = Integer.parseInt(splited[1]);
		
		splited = in.readLine().split(" ");
		int X = Integer.parseInt(splited[0]);
		int Y = Integer.parseInt(splited[1]);
		
		int t = Integer.parseInt(in.readLine());
		
		X = w - Math.abs(w - (X + t) % (2 * w));
		Y = h - Math.abs(h - (Y + t) % (2 * h));
		
		System.out.println(X + " " + Y);
	}	
}
