import java.util.*;

public class 신고결과받기 {

	public static void main(String[] args) {		
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		int[] answer = solution(id_list, report, k);	
		System.out.println(Arrays.toString(answer));
	}
	
	static class User{
		String name;
		int count;
		Stack<String> stack = new Stack<String>();
		
		public User(String name, int count, Stack<String> stack) {
			super();
			this.name = name;
			this.count = count;
			this.stack = stack;
		}
		
	}

	public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        ArrayList<User> list = new ArrayList<User>();
        for(String id : id_list) {
        	list.add(new User(id, 0, new Stack<String>()));
        }
        
        for(String input : report) {
        	String[] splited = input.split(" ");
        	for(int i = 0; i < list.size(); i++) {
        		if(list.get(i).name.equals(splited[1]) && !list.get(i).stack.contains(splited[0])) {
        			list.get(i).count++;
        			list.get(i).stack.add(splited[0]);
        		}
        	}
        }
        
        for(int i = 0; i < list.size(); i++) {
        	if(list.get(i).stack.size() >= k) {
        		while(!list.get(i).stack.isEmpty()) {
        			String reporter = list.get(i).stack.pop();
        			for(int j = 0; j < id_list.length; j++) {
        				if(id_list[j].equals(reporter)) {
        					answer[j]++;
        				}
        			}
        		}
        	}
        }
        
        return answer;
    }
}
