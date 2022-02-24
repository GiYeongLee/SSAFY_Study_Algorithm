import java.io.*;
import java.util.*;

public class BJ_1786_찾기 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		char[] text = in.readLine().toCharArray();
		char[] pattern = in.readLine().toCharArray();
		
		int tLength = text.length;
		int pLength = pattern.length;
		
		// 부분일치테이블 생성
		int[] pi = new int[pLength];
		int head = 0;	// 접두사 포인터
	    for(int tail = 1; tail < pLength; tail++){	// tail : 접미사 포인터
	        while(head > 0 && pattern[tail] != pattern[head]) head = pi[head - 1]; 
	        
	        if(pattern[tail] == pattern[head]) pi[tail] = ++head;
	        else pi[tail] = 0;
	    }
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();

		int pp = 0;	// 패턴 포인터
		for(int tp = 0; tp < tLength; ++tp) {	// tp : 텍스트 포인터 
			
			while(pp > 0 && text[tp] != pattern[pp]) pp = pi[pp - 1]; 
			
			if(text[tp] == pattern[pp]) {	// 글자 일치
				if(pp == pLength - 1) {		// j가 패턴의 마지막 인덱스라면 
					cnt++;	// 카운트 증가
					list.add((tp + 1) - pLength + 1);  
					pp = pi[pp]; 
				}
				else pp++;
			}
		}
		
		builder.append(cnt + "\n");
		if(cnt > 0) {
			for(int i = 0; i < list.size(); i++) {
				builder.append(list.get(i) + " ");
			}
		}
		
		System.out.println(builder.toString());
	}
}