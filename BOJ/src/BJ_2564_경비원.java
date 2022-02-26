import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2564_경비원 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		
		int length = Integer.parseInt(splited[0]);
		int height = Integer.parseInt(splited[1]);
		int storeNum = Integer.parseInt(in.readLine());
		
		int[][] store = new int[storeNum][2];
		int[] person = new int[2];
		
		// 1 : 북쪽
		// 2 : 남쪽
		// 3 : 서쪽
		// 4 : 동쪽
		// 왼쪽부터, 위쪽부터
		
		for(int i = 0; i < storeNum; i++) {
			splited = in.readLine().split(" ");
			store[i][0] = Integer.parseInt(splited[0]);
			store[i][1] = Integer.parseInt(splited[1]);
		}
		splited = in.readLine().split(" ");
		person[0] = Integer.parseInt(splited[0]);
		person[1] = Integer.parseInt(splited[1]);
		
		int sum = 0;
		
		switch(person[0]) {
		case 1:	// 사람 - 북
			for(int i = 0; i < storeNum; i++) {
				switch(store[i][0]) {
				case 1: // 상점 - 북
					sum += Math.abs(person[1] - store[i][1]);
					break;
				case 2:	// 상점 - 남
					sum += Math.min(person[1] + height + store[i][1], length - person[1] + height + length - store[i][1]);
					break;
				case 3:	// 상점 - 서
					sum += (person[1] + store[i][1]);
					break;
				case 4:	// 상점 - 동
					sum += (length - person[1] + store[i][1]);
					break;
				}
			}
			break;
		case 2:	// 사람 - 남
			for(int i = 0; i < storeNum; i++) {
				switch(store[i][0]) {
				case 1:	// 상점 - 북
					sum += Math.min(person[1] + height + store[i][1], length - person[1] + height + length - store[i][1]);
					break;
				case 2:	// 상점 - 남
					sum += Math.abs(person[1] - store[i][1]);
					break;
				case 3:	// 상점 - 서
					sum += (person[1] + height - store[i][1]);
					break;
				case 4:	// 상섬 - 동
					sum += (length - person[1] + height - store[i][1]);
					break;
				}
			}
			break;
		case 3:	// 사람 - 서
			for(int i = 0; i < storeNum; i++) {
				switch(store[i][0]) {
				case 1:	// 상점 - 북
					sum += (person[1] + store[i][1]);
					break;
				case 2:	// 상점 - 남
					sum += (height - person[1] + store[i][1]);
					break;
				case 3:	// 상점 - 서
					sum += Math.abs(person[1] - store[i][1]);
					break;
				case 4:	// 상섬 - 동
					sum += Math.min(person[1] + length + store[i][1], height - person[1] + length + height - store[i][1]);
					break;
				}
			}
			break;
		case 4:	// 사랑 - 동
			for(int i = 0; i < storeNum; i++) {
				switch(store[i][0]) {
				case 1:	// 상점 - 북
					sum += (person[1] + length - store[i][1]);
					break;
				case 2:	// 상점 - 남
					sum += (height - person[1] + length - store[i][1]);
					break;
				case 3:	// 상점 - 서
					sum += Math.min(person[1] + length + store[i][1], height - person[1] + length + height - store[i][1]);
					break;
				case 4:	// 상점 - 동
					sum += Math.abs(person[1] - store[i][1]);
					break;
				}
			}
			break;
		}
		
		System.out.println(sum);
	}
}
