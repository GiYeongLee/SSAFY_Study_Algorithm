package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class D3_6808_규영이와인영이의카드게임 {
	
	static ArrayList<Integer> cardA;
	static ArrayList<Integer> cardB;
	static int[] cardB_final;
	static boolean[] isChecked;
	static int winCount;
	static int loseCount;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int t = 1; t <= TC; t++) {
			cardA = new ArrayList<Integer>();
			cardB = new ArrayList<Integer>();
			cardB_final = new int[9];
			isChecked = new boolean[9];
			winCount = 0;
			loseCount = 0;

			boolean[] cardCheck = new boolean[18];
			
			String[] splited = in.readLine().split(" ");
			
			for(int i = 0; i < 9; i++) {
				cardA.add(Integer.parseInt(splited[i]));
				cardCheck[cardA.get(i) - 1] = true;
			}
			
			for(int i = 0; i < 18; i++) {
				if(cardCheck[i] == false) cardB.add(i + 1);
			}
			
			func(0);			
			System.out.println("#" + t + " " + winCount + " " + loseCount);
		}		
	}
	
	public static void func(int count) {
		
		if(count == 9) {
			int aScore = 0;
			int bScore = 0;
			
			for(int i = 0; i < 9; i++) {	
				if(cardB_final[i] == cardA.get(i)) continue;
				else if(cardB_final[i] > cardA.get(i)) bScore += (cardB_final[i] + cardA.get(i));
				else if(cardB_final[i] < cardA.get(i)) aScore += (cardB_final[i] + cardA.get(i));
			}
			
			if(aScore == bScore) return;
			else if(aScore > bScore) winCount++;
			else if(aScore < bScore) loseCount++;
			
			return;
		}
		
		for(int i = 0; i < cardB.size(); i++) {			
			if(isChecked[i] == true) continue;
			
			isChecked[i] = true;
			cardB_final[count] = cardB.get(i);
			func(count + 1);
			isChecked[i] = false;
		}
	}
}
