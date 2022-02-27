import java.io.*;

public class BJ_2947_나무 {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int[] arr = new int[5];
		
		String[] splited = in.readLine().split(" ");
		for(int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(splited[i]);
		}

		while(true) {
			int flag = 0;
			for(int i = 0; i < 4; i++) {
				if(arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					for(int j = 0; j < 5; j++) {
						builder.append(arr[j] + " ");
					}
					builder.setLength(builder.length() - 1);
					builder.append("\n");
					continue;
				}
				flag++;
			}
			if(flag == 4) break;
		}
		builder.setLength(builder.length() - 1);
		System.out.println(builder.toString());
	}
}
