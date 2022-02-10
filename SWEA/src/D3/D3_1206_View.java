package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1206_View {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			
			int N = Integer.parseInt(in.readLine());
			
			int[] arr = new int[N + 4];
			String str = in.readLine();
			String[] splited = str.split(" ");
			int count = 0;
			
			for(int i = 0; i < N + 4; i++) {
				if(i == 0 || i == 1 || i == (N + 2) || i == (N + 3)) arr[i] = 0;
				else arr[i] = Integer.parseInt(splited[i - 2]);
			}
			
			for(int i = 2; i < (N + 2); i++) {
				int temp = arr[i];
				while(temp > 0) {
					if(arr[i - 2] < temp && arr[i - 1] < temp && arr[i + 1] < temp && arr[i + 2] < temp) count++;
					else break;
					temp--;
				}
			}	
			System.out.println("#" + t + " " + count);
		}
	}
}
