import java.io.*;

public class BJ_3060_욕심쟁이돼지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= TC; t++) {
			
			long N = Long.parseLong(in.readLine());
			long[] pig = new long[6];
			
			String[] splited = in.readLine().split(" ");
				
			long sum = 0;
			for(int i = 0; i < 6; i++) {
				pig[i] = Long.parseLong(splited[i]);
				sum += pig[i];
			}
			if(sum > N) {
				builder.append("1\n");
				continue;
			}
			
			long count = 1;
			
			while(true) {
				sum = 0;
				long[] temp = new long[6];
				for(int i = 0; i < 6; i++) {
					temp[i] = pig[i] + pig[(i + 1) % 6] + pig[(i + 3) % 6] + pig[(i + 5) % 6];
					sum += temp[i];
				}
				count++;
				if(sum > N) break;
				pig = temp;
			}			
			builder.append(count + "\n");
		}
		System.out.println(builder.toString());
	}
}
