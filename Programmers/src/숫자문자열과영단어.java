import java.util.*;

public class 숫자문자열과영단어 {
	
	public int solution(String s) {	
        
        StringBuilder builder = new StringBuilder();
        HashMap<String, String> map = new HashMap<String, String>();
        
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        map.put("zero", "0");
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') builder.append(s.charAt(i));
            else {
                String temp = "";
                while(!map.containsKey(temp)){
                    temp += s.charAt(i++);
                }
                builder.append(map.get(temp));
                i--;
            }
        }
        
        return Integer.parseInt(builder.toString());
    }
}
