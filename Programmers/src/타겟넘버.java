import java.util.*;

public class 타겟넘버 {

	public static void main(String[] args) {
		
		int[] numbers = {4, 1, 2, 1};
		int target = 4;
		
		System.out.println(solution(numbers, target));

	}
	
	static boolean[] selected;
	static int answer = 0;

	public static int solution(int[] numbers, int target) {   
        selected = new boolean[numbers.length];
        permutation(0, numbers, target);
        return answer;
    }
	
	public static void permutation(int cnt, int[] numbers, int target) {
		if(cnt == selected.length) {
			if(calcSum(numbers) == target) answer++;
			return;
		}
		
		for(int i = 0; i < 2; i++) {
			if(i == 0) selected[cnt] = true;
			else selected[cnt] = false;
			
			permutation(cnt + 1, numbers, target);
		}
	}
	
	public static int calcSum(int[] numbers) {
		int sum = 0;
		
		for(int i = 0; i < selected.length; i++) {
			if(selected[i]) sum += numbers[i];
			else sum -= numbers[i];
		}
		
		return sum;
	}
}
