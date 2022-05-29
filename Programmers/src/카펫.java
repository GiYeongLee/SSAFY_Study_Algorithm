
public class 카펫 {
	public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        
        for(int i = 1; i < total; i++){
            int x = i;
            int y = total / i;
            
            if((x - 2) * (y - 2) == yellow){
                answer[0] = x;
                answer[1] = y;
            }
        }
        
        return answer;
    }
}
