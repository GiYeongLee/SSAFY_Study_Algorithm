import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		String[] splited = in.readLine().split(" ");
		
		int N = Integer.parseInt(splited[0]);
		int K = Integer.parseInt(splited[1]);
		
		Queue<String> queue = new LinkedList<String>();
		
		for(int i = 1; i <= N; i++) queue.offer(Integer.toString(i));
		
		builder.append("<");
		while(!queue.isEmpty()) {
			for(int i = 0; i < K - 1; i++) queue.offer(queue.poll());
			builder.append(queue.poll() + ", ");
		}
		builder.setLength(builder.length() - 2);
		builder.append(">");
		System.out.println(builder.toString());
	}
}
