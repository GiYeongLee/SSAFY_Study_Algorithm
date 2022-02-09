import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2564_경비원 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] block = in.readLine().split(" ");
		int blockX = Integer.parseInt(block[1]);
		int blockY = Integer.parseInt(block[0]);
		int numStore = Integer.parseInt(in.readLine());
		int[] position = new int[numStore];
		int[] distance = new int[numStore];
		for(int i = 0; i < numStore; i++) {
			String[] store = in.readLine().split(" ");
			position[i] = Integer.parseInt(store[0]);
			distance[i] = Integer.parseInt(store[1]);
		}
		String[] person = in.readLine().split(" ");
		int personPosition = Integer.parseInt(person[0]);
		int personDistance = Integer.parseInt(person[1]);
		
		int[] line;
		
		for(int i = 0; i < numStore; i++) {
			
			line = new int[(blockX + blockY) * 2];
			
			if(personPosition == 1) {
				if(position[i] == 1) {
					line[]
				}
			}
			
		}
		
		

	}

}
