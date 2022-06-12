import java.util.*;

public class 다리를지나는트럭 {

	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10};
		
		System.out.println(solution(bridge_length, weight, truck_weights));
	}
	
	static Queue<int[]> run = new LinkedList<int[]>();
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> wait = new LinkedList<Integer>();
        for(int i : truck_weights) wait.add(i);
        
        int totalWeight = 0;
        
        while(!wait.isEmpty()) {
        	
        	if(!run.isEmpty() && run.peek()[1] == 0) {
        		totalWeight -= run.peek()[0];
        		run.poll();
        	}
        	
        	answer++;
        	
        	if(run.size() >= bridge_length) {
        		reduceTime();
        		continue;
        	}
        	
        	if(run.isEmpty()) {
        		totalWeight += wait.peek();
        		run.add(new int[] {wait.poll(), bridge_length - 1});
        	} else {
        		reduceTime();
        		if(totalWeight + wait.peek() <= weight) {
        			totalWeight += wait.peek();
            		run.add(new int[] {wait.poll(), bridge_length - 1});
            	} 
        	}
        }
        
        return answer + bridge_length;
    }
	
	public static void reduceTime() {
		int size = run.size();
		
		for(int i = 0; i < size; i++) {
			run.add(new int[] {run.peek()[0], run.poll()[1] - 1});
		}
	}

}
