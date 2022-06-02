import java.util.*;

public class 오픈채팅방 {

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan", "Leave uid4567"};
		System.out.println(Arrays.toString(solution(record)));
	}
	
	public static String[] solution(String[] record) {
		ArrayList<String> answer = new ArrayList<String>();
        HashMap<String, String> map = new HashMap<String, String>();
        
        for(int i = 0; i < record.length; i++){
            String[] splited = record[i].split(" ");
            String command = splited[0];
            
            if(command.equals("Leave")) continue;
            
            String uid = splited[1];
            String name = splited[2];
            
            map.put(uid, name);
        }
        
        for(int i = 0; i < record.length; i++){
            String[] splited = record[i].split(" ");
            String command = splited[0];
            String name = map.get(splited[1]);
            
            switch(command){
                case "Enter":
                    answer.add(name + "님이 들어왔습니다.");
                    break;
                case "Leave":
                	answer.add(name + "님이 나갔습니다.");
                    break;
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }

}
