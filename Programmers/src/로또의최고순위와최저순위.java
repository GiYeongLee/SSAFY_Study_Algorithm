import java.util.*;

public class 로또의최고순위와최저순위 {

	public static void main(String[] args) {
		int[] lottos = {0, 0, 0, 0, 0, 0};
		int[] win_nums = {38, 19, 20, 40, 15, 25};
		
		System.out.println(Arrays.toString(solution(lottos, win_nums)));
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        
        int unknown = 0;
        int count = 0;
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i = 0; i < lottos.length; i++) {
        	if(lottos[i] == 0) unknown++;
        	else set.add(lottos[i]);
        }
        
        for(int i = 0; i < win_nums.length; i++) {
        	if(set.contains(win_nums[i])) {
        		count++;
        	}
        }
        
        answer[0] = rank[count + unknown];
        answer[1] = rank[count];
        
        return answer;
    }

}
