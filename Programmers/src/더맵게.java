import java.util.*;

public class 더맵게 {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(solution(scoville, K));
	}
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i : scoville) pq.add(i);
        
        while(pq.peek() < K) {
        	pq.add(pq.poll() + (pq.poll() * 2));
        	answer++;
        }
        
        return answer;
    }

}
