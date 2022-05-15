import java.util.*;

public class K번째수 {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(Arrays.toString(solution(array, commands)));
	}
	
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        for(int t = 0; t < commands.length; t++) {
        	for(int i = commands[t][0] - 1; i < commands[t][1]; i++) {
        		temp.add(array[i]);
        	}
        	Collections.sort(temp);
        	answer[t] = temp.get(commands[t][2] - 1);
        	temp.clear();
        }
        
        return answer;
    }

}
