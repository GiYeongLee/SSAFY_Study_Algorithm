import java.io.*;
import java.util.*;

public class 순열조합부분집합 {
	
	static int[] input;	// 원본 배열
	static int[] result;	// 뽑은 배열
	static boolean[] isSelected;	// 수의 선택 여부를 저장할 배열
	static int N;
	static int R;
	static int finalCount = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());	// 원본 배열 개수
		R = Integer.parseInt(in.readLine());	// 뽑을 개수
		input = new int[N];
		result = new int[R];
		isSelected = new boolean[N];
		
		String[] splited = in.readLine().split(" ");
		
		for(int i = 0; i < N; i++) input[i] = Integer.parseInt(splited[i]);
		
		//func1(0);	// 순열
		//func2(0, 0);	// 조합
		func3(0);	// 부분집합
		System.out.println(finalCount);	// 경우의 수 출력
	}
	
	// 순열
	// 순서 의미 O
	public static void func1(int count) {
		if(count == R) {	// 뽑는 개수가 모두 채워지면 return
			System.out.println(Arrays.toString(result));
			finalCount++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isSelected[i]) continue;	// 이미 뽑은 수라면 continue ( 중복 방지 )
			
			result[count] = input[i];
			isSelected[i] = true;	// 뽑았음을 저장
			func1(count + 1);
			isSelected[i] = false;	// 다음 시행을 위해 초기화
			
			// isSelected를 빼면 중복 순열
		}
	}
	
	// 조합
	// 순서에 의미 없음
	public static void func2(int count, int idx) {
		if(count == R) {	// 뽑는 개수가 모두 채워지면 return
			System.out.println(Arrays.toString(result));
			finalCount++;
			return;
		}
		
		for(int i = idx; i < N; i++) {
			result[count] = input[i];
			func2(count + 1, i + 1);	// 다음 인덱스부터 넘겨서 중복을 방지
			
			// func2(count + 1, i)로 하면 중복 조합이 된다
		}
	}
	
	// 부분집합
	public static void func3(int count) {
		if(count == N) {
			for(int i = 0; i < N; i++) {
				if(isSelected[i] == true) {
					System.out.print(input[i] + " ");
				}
			}
			System.out.println();
			finalCount++;
			return;
		}
		
		
		isSelected[count] = true;	// 현재 원소를 선택
		func3(count + 1);
		isSelected[count] = false;	// 현재 원소를 비선택
		func3(count + 1);
	}
}
