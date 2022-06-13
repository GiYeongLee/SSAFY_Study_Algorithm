public class 문자열압축 {

	public static void main(String[] args) {
		
		String s = "a";
		System.out.println(solution(s));

	}

	public static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        if(s.length() == 1) answer = 1;
        
        for(int i = 1; i <= s.length() / 2; i++) {
        	String str = s.substring(0, i);
        	int sum = 0;
        	int num = 1;
        	
        	for(int j = i; j <= s.length(); j += i) {
        		String temp;
        		
        		if(j + i < s.length()) temp = s.substring(j, j + i);
        		else temp = s.substring(j, s.length());
        		
        		if(str.equals(temp)) num++;
        		else {
        			if(num > 1) sum += (str.length() + (Math.log10(num) + 1));
        			else sum += str.length();

        			str = temp;
        			num = 1;
        		}
        	}
        	answer = Math.min(answer, sum + str.length());
        }   
        return answer;
    }
}
