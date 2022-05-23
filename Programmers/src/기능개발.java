import java.util.*;

public class 기능개발 {

	public static void main(String[] args) {
		
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		
		System.out.println(Arrays.toString(solution(progresses, speeds)));

	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] temp = new int[100];
        int[] counting = new int[100];
        
        int day = -1;
        
    	for(int i = 0; i < progresses.length; i++) {
        	while(true) {
        		if(progresses[i] + (speeds[i] * day) >= 100) {
        			counting[day]++;
        			break;
        		}
        		day++;
        	}
        }
    	
    	int count = 0;
    	int sum = 0;
    	for(int i = 0; i < 100; i++) {
    		if(counting[i] > 0) {
    			sum += counting[i];
    			temp[count++] = counting[i];
    		}
    		if(sum == progresses.length) break;	
    	}
    	
    	int[] answer = new int[count];
    	for(int i = 0; i < count; i++) {
    		answer[i] = temp[i];
    	}
        
        return answer;
    }

}
