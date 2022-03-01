import java.io.*;

public class BJ_10709_기상캐스터 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		String[] splited = in.readLine().split(" ");
		int H = Integer.parseInt(splited[0]);
		int W = Integer.parseInt(splited[1]);
		
		for(int i = 0; i < H; i++) {
			String input = in.readLine();	
			int flag = 0;
			int count = 0;
			for(int j = 0; j < W; j++) {
				if(input.charAt(j) == 'c') {
					count = 0;
					flag = 1;
				}
				if(flag == 0) builder.append("-1 ");
				else {
					builder.append(count + " ");
					count++;
				}
			}
			builder.append("\n");
		}
		System.out.println(builder.toString());
	}
}
