import java.util.*;

public class 메뉴리뉴얼 {

	public static void main(String[] args) {
		String[] orders = {"XYZ", "XWY", "WXA"}; 
		int[] course = {2, 3, 4};
		
		System.out.println(Arrays.toString(solution(orders, course)));
	}
	
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	static char[] selected;
	static boolean[] visited;
	
	public static String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<String>();
        
        for(int j = 0; j < course.length; j++) {
        	for(int i = 0; i < orders.length; i++) {
            	selected = new char[course[j]];
            	combination(orders[i], 0, course[j], 0);
            }
        	
        	int max = 0;
        	
        	for(String key : map.keySet()) {
        		if(map.get(key) > max && map.get(key) >= 2) max = map.get(key);
        	}
        	
        	if(max == 1) continue;
        	
        	for(String key : map.keySet()) {
        		if(map.get(key) == max) pq.add(key);
        	}
        	
        	map.clear();
        }
        
        
        String[] answer = new String[pq.size()];
        int size = pq.size();
        for(int i = 0; i < size; i++) {
        	answer[i] = pq.poll();
        }
        
        return answer;
    }
	
	public static void combination(String order, int cnt, int N, int start) {
		if(cnt == N) {
			char[] copy = selected.clone();
			Arrays.sort(copy);
			String temp = new String(copy);
			if(map.containsKey(temp)) map.put(temp, map.get(temp) + 1);
			else map.put(temp, 1);
			return;
		}
		
		for(int i = start; i < order.length(); i++) {
			selected[cnt] = order.charAt(i);
			combination(order, cnt + 1, N, i + 1);
			
		}
	}

}
