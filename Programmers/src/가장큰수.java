import java.util.*;

public class 가장큰수 {

	public static void main(String[] args) {
		int[] numbers = {6, 10, 2};
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
		String[] arr = new String[numbers.length];
		for(int i = 0; i < numbers.length; i++) {
			arr[i] = Integer.toString(numbers[i]);
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
			
		});
		
		if(arr[0].equals("0")) return "0";
		
		String answer = "";
		for(int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		
		return answer;
	}
}
