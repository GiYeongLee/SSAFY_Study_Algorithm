import java.util.*;
import java.io.*;

public class BJ_1244_스위치켜고끄기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		int switchNum = Integer.parseInt(in.readLine());	
		int[] switchArr = new int[switchNum];	
		String[] splited = in.readLine().split(" ");	
		for(int i = 0; i < switchNum; i++) switchArr[i] = Integer.parseInt(splited[i]);
		int personNum = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < personNum; i++) {
			splited = in.readLine().split(" ");
			int sex = Integer.parseInt(splited[0]);
			int num = Integer.parseInt(splited[1]) - 1;
			
			switch(sex) {
			case 1:
				int temp = num + 1;
				while(num < switchNum) {
					if(switchArr[num] == 1) switchArr[num]--;
					else if(switchArr[num] == 0) switchArr[num]++;
					num = num + temp;
				}
				break;
			case 2:
				if(switchArr[num] == 1) switchArr[num] = 0;
				else if(switchArr[num] == 0) switchArr[num] = 1;
				
				int idx = 1;
				while(true) {
					if(num - idx < 0 || num + idx >= switchNum) break;
					if(switchArr[num - idx] != switchArr[num + idx]) break;
					
					if(switchArr[num - idx] == 1) {
						switchArr[num - idx]--; switchArr[num + idx]--;
					}
					else if(switchArr[num - idx] == 0) {
						switchArr[num - idx]++; switchArr[num + idx]++;
					}
					idx++;
				}
				break;
			}
		}
		
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < switchNum; i++) {
			if(i != 0 && i % 20 == 0) {
				builder.append("\n");
			}
			builder.append(switchArr[i] + " ");
		}
		
		builder.setLength(builder.length() - 1);
		System.out.println(builder.toString());
	}
}
