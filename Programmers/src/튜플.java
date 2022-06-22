import java.util.*;

public class 튜플 {

	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		System.out.println(solution(s).toString());

	}
	
	public static ArrayList<Integer> solution(String s) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        s = s.substring(2, s.length());
        s = s.substring(0, s.length() - 2);
        s = s.replace("},{", " ");
        
        s = s.replace("{", "");
        s = s.replace("}", "");
        
        String[] splited = s.split(" ");
        
        Arrays.sort(splited, Comparator.comparing(String::length));
        
        for(String str : splited) {
        	String[] subSplited = str.split(",");
        	for(String subStr : subSplited) {
        		int temp = Integer.parseInt(subStr);
        		if(list.contains(temp)) continue;
        		list.add(temp);
        	}
        }
        
        return list;
    }

}
