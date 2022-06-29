
public class 최대공약수와최소공배수 {

	public static void main(String[] args) {

	}
	
	public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int big = Math.max(n,  m);
        int small = Math.min(n, m);
        int temp = big * small;
        int remain;
        while(small != 0) {
        	remain = big % small;
        	big = small;
        	small = remain;
        }
        answer[0] = big;
        answer[1] = temp / big;
        
        
        return answer;
    }

}
