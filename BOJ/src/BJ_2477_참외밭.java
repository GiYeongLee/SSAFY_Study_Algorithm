import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2477_참외밭 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int fruit = Integer.parseInt(in.readLine());
		
		int longestIndex = 0;
		int longestLength = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		
		
		for(int i = 0; i < 6; i++) {
			String[] splited = in.readLine().split(" ");
			int temp = Integer.parseInt(splited[1]);
			if(temp > longestLength) {	// 가장 길이가 긴 데이터를 찾는다
				longestLength = temp;
				longestIndex = i;	// 가장 길이가 긴 데이터가 몇번째 데이터인지 저장한다
			}
			queue.offer(temp);
		}
		
			for(int i = 0; i < longestIndex; i++) {	// 가장 긴 데이터가 queue의 맨 앞에 오도록 한다
				queue.offer(queue.poll());
			}
		
		queue.poll();	// 가장 긴 데이터는 이제 필요없으므로 poll
		int[] lengthTemp = new int[2];
		int[] heightTemp = new int[3];
		heightTemp[0] = queue.poll();	// heightTemp[2]보다 작다면 lengthTemp[0]이 잘린 부분의 길이
		lengthTemp[0] = queue.poll();
		heightTemp[1] = queue.poll();	// 항상 잘린 부분의 높이
		lengthTemp[1] = queue.poll();	
		heightTemp[2] = queue.poll();	// heightTemp[0]보다 작다면 lengthTemp[1]이 잘린 부분의 길이
		
		if(heightTemp[0] > heightTemp[2]) {
			System.out.println(((heightTemp[0] * longestLength) - (heightTemp[1] * lengthTemp[1])) * fruit);
		}
		else if(heightTemp[0] < heightTemp[2]) {
			System.out.println(((heightTemp[2] * longestLength) - (heightTemp[1] * lengthTemp[0])) * fruit);
		}
	}

}
