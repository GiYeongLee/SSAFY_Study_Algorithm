import java.util.*;

public class 키패드누르기 {

	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";

		solution(numbers, hand);
	}
	
	static String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();
		
		int Lhand = 10;
		int Rhand = 12;
		
		for(int num : numbers) {
			switch(num) {
			case 1:
			case 4:
			case 7:
				Lhand = num;
				answer.append("L");
				break;
			case 3:
			case 6:
			case 9:
				Rhand = num;
				answer.append("R");
				break;
			case 2:
			case 5:
			case 8:
			case 0:
				int Ldist = getDist(Lhand, num);
				int Rdist = getDist(Rhand, num);
				
				if(Ldist > Rdist) {
					answer.append("R");
					Rhand = num;
				} else if(Rdist > Ldist) {
					answer.append("L");
					Lhand = num;
				} else {
					switch(hand) {
					case "left":
						answer.append("L");
						Lhand = num;
						break;
					case "right":
						answer.append("R");
						Rhand = num;
						break;
					}
				}
				break;
			}
		}
		
		return answer.toString();
	}
	
	static int getDist(int from, int to) {
		if(from == 0) from = 11;
		if(to == 0) to = 11;
		
		int fromX = (from - 1) / 3;
		int fromY = (from - 1) % 3;
		int toX = to / 3;
		int toY = 1;
		
		return Math.abs(fromX - toX) + Math.abs(fromY - toY);
	}

}
