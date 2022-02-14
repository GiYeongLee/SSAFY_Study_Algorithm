import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2961_도영이가만든맛있는음식 {
	
	static int N;
	static ArrayList<int[]> list;
	static boolean[] isSelected;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		list = new ArrayList<int[]>();
		isSelected = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			String[] splited = in.readLine().split(" ");
			list.add(new int[] {Integer.parseInt(splited[0]), Integer.parseInt(splited[1])});
		}
		
		func(0);
		
		System.out.println(min);
	}

	public static void func(int cnt) {
		if(cnt == N) {
			int flag = 0;
		
			int sour = 1;
			int bitter = 0;
			for(int i = 0; i < list.size(); i++) {	
				if(isSelected[i] == true) {
					int[] temp = list.get(i);
					sour *= temp[0];
					bitter += temp[1];
				}
				else flag++;
			}
			if(flag == list.size()) return;			
			if(Math.abs(sour - bitter) < min) min = Math.abs(sour - bitter);
			return;
		}
		isSelected[cnt] = true;
		func(cnt + 1);
		isSelected[cnt] = false;
		func(cnt + 1);
	}
}
