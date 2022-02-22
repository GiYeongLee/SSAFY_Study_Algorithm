import java.io.*;
import java.util.*;

public class BJ_2304_창고다각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		class storage implements Comparable<storage>{	// 창고 객체
			int loc;	// 위치
			int height;	// 높이
			
			public storage(int loc, int height) {
				this.loc = loc;
				this.height = height;
			}
			
			@Override
			public int compareTo(storage o) {	// 위치를 기준으로 오름차순 정렬
				return this.loc - o.loc;
			}		
		}
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		storage[] list = new storage[N];	// 창고 객체를 저장할 배열 생성
		
		for(int i = 0; i < N; i++) {	// 입력
			String[] splited = in.readLine().split(" ");
			list[i] = new storage(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]));
		}
		
		Arrays.sort(list);	// 창고 위치를 기준으로 오름차순 정렬
		
		int max = 0;	// 가장 높은 창고의 높이를 저장할 변수
		ArrayList<Integer> maxIdx = new ArrayList<Integer>();	// 가장 높은 창고들의 인덱스를 저장할 ArrayList
		ArrayList<Integer> maxLoc = new ArrayList<Integer>();	// 가장 높은 창고들의 위치를 저장할 ArrayList
		
		for(int i = 0; i < N; i++) {
			if(list[i].height > max) {	// 더 높은 창고라면
				maxIdx.clear();	// 기존에 저장된 데이터 초기화
				maxLoc.clear();
				max = list[i].height;	// 다시 저장
				maxLoc.add(list[i].loc);
				maxIdx.add(i);
				continue;
			}
			if(list[i].height == max) {	// 가장 높은 창고와 같은 높이의 창고라면
				maxLoc.add(list[i].loc);	// 데이터를 ArrayList에 추가
				maxIdx.add(i); 
			}
		}
		
		Collections.sort(maxIdx);	// 오름차순 정렬
		Collections.sort(maxLoc);
		
		int sum = 0;	// 전체 면적
		
		if(maxIdx.size() == 1) sum = max;	// 가장 높은 창고가 하나라면 높이만큼의 면적을 추가
		else sum = max * (maxLoc.get(maxLoc.size() - 1) - maxLoc.get(0) + 1);	// 가장 높은 창고가 여러개라면 어째저째해서 가장 높은 창고들 사이의 면적을 추가
		
		int temp = 1;	// 계산용
		
		for(int i = 1; i <= maxIdx.get(0); i++) {	// 왼쪽에서 오른쪽으로 가장 높은 창고를 만날때까지 면적 계산
			if(list[i].height > list[i - temp].height) {
				sum += (list[i].loc - list[i - temp].loc) * list[i - temp].height;
				temp = 1;
			}
			else temp++;
		}
		
		temp = 1;
		
		for(int i = N - 2; i >= maxIdx.get(maxIdx.size() - 1); i--) {	// 오른쪽에서 왼쪽으로
			if(list[i].height > list[i + temp].height) {
				sum += (list[i + temp].loc - list[i].loc) * list[i + temp].height;
				temp = 1;
			}
			else temp++;
		}
		
		System.out.println(sum);
	}
}
