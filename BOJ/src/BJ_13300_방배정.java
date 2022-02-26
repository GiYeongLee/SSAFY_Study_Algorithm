import java.io.*;

public class BJ_13300_방배정 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] splited = in.readLine().split(" ");
		
		int N = Integer.parseInt(splited[0]);
		int K = Integer.parseInt(splited[1]);
		
		int[] man = new int[7];
		int[] woman = new int[7];
		
		for(int i = 0; i < N; i++) {
			splited = in.readLine().split(" ");
			int sex = Integer.parseInt(splited[0]);
			int grade = Integer.parseInt(splited[1]);
			
			switch(sex) {
			case 0:	// 여학생
				woman[grade]++;
				break;
			case 1:	// 남학생
				man[grade]++;
				break;
			}
		}
		
		int room = 0;
		
		for(int i = 1; i <= 6; i++) {
			if(man[i] % K != 0) room += man[i] / K + 1;
			else if(man[i] % K == 0) room += man[i] / K;
			
			if(woman[i] % K != 0) room += woman[i] / K + 1;
			else if(woman[i] % K == 0) room += woman[i] / K;
		}
		
		System.out.println(room);
		
	}
	
}
