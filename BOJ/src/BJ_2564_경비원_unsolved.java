import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_2564_경비원_unsolved {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		
		int I = Integer.parseInt(splited[0]);
		int J = Integer.parseInt(splited[1]);
		
		int storeNum = Integer.parseInt(in.readLine());
		Stack<int[]> stack = new Stack<int[]>();
		
		for(int i = 0; i < storeNum; i++) {
			String[] splited2 = in.readLine().split(" ");
			stack.push(new int[] {Integer.parseInt(splited2[0]), Integer.parseInt(splited2[1])});
		}
		
		String[] splited2 = in.readLine().split(" ");
		int[] person = {Integer.parseInt(splited2[0]), Integer.parseInt(splited2[1])};
		
		for(int i = 0; i < storeNum; i++) {
			
		}
	}
}
