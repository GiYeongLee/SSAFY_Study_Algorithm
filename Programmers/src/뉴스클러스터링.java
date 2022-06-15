import java.util.*;

public class 뉴스클러스터링 {

	public static void main(String[] args) {
		
		String str1 = "aa1+aa2";
		String str2 = "AAAA12";
		
		System.out.println(solution(str1, str2));

	}
	
	public static int solution(String str1, String str2) {
        
		int hap = 0;
		int gyo = 0;
		
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        Map<String, Integer> mapA = new HashMap<String, Integer>();
        Map<String, Integer> mapB = new HashMap<String, Integer>();
        
        for(int i = 0; i < str1.length() - 1; i++) {
        	if(str1.charAt(i) < 'A' || str1.charAt(i) > 'Z' || str1.charAt(i + 1) < 'A' || str1.charAt(i + 1) > 'Z') continue;
        	
        	String temp = str1.substring(i, i + 2);
       	
        	if(mapA.containsKey(temp)) mapA.put(temp, mapA.get(temp) + 1);
        	else mapA.put(temp, 1);
        }
        
        for(int i = 0; i < str2.length() - 1; i++) {
        	if(str2.charAt(i) < 'A' || str2.charAt(i) > 'Z' || str2.charAt(i + 1) < 'A' || str2.charAt(i + 1) > 'Z') continue;
        	
        	String temp = str2.substring(i, i + 2);
       	
        	if(mapB.containsKey(temp)) mapB.put(temp, mapB.get(temp) + 1);
        	else mapB.put(temp, 1);
        }
        
        for(String key : mapA.keySet()) {
        	if(mapB.containsKey(key)) {
        		hap += Math.max(mapA.get(key), mapB.get(key));
        		gyo += Math.min(mapA.get(key), mapB.get(key));
        		mapB.remove(key);
        	} 
        	else hap += mapA.get(key);
        }
        
        for(String key : mapB.keySet()) {
        	hap += mapB.get(key);
        }
        
        if(hap == 0) return 65536;
        else return (int) Math.floor(65536 * ((double) gyo / hap));
        
    }

}
