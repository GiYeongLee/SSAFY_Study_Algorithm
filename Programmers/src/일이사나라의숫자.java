public class 일이사나라의숫자 {

	public static void main(String[] args) {
		
		int n = 10;
		System.out.println(solution(n));

	}
	
	public static String solution(int n) {
        StringBuilder answer = new StringBuilder();
        
        while(n > 0) {
        	int temp = n % 3;
        	switch(temp) {
        	case 0:
        		answer.append("4");
        		n = (n / 3) - 1;
        		break;
        	case 1:
        		answer.append("1");
        		n = n / 3;
        		break;
        	case 2:
        		answer.append("2");
        		n = n / 3;
        		break;
        	}
        }
        
        answer.reverse();      
        return answer.toString();
    }

}
