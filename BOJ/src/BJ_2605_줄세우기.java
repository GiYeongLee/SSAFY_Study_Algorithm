import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ_2605_줄세우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(in.readLine());
		LinkedList<Integer> list = new LinkedList<Integer>();
		int person = 1;		
		String[] splited = in.readLine().split(" ");
		for(int i = 0; i < N; i++) list.add(list.size() - Integer.parseInt(splited[i]), person++);
		for(int i = 0; i < N; i++) System.out.print(list.poll() + " ");
	}
}
