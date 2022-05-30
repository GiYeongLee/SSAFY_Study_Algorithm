import java.util.*;

public class 프린터 {
	public int solution(int[] priorities, int location) {
        int answer = 1;
        
        int[] priority = new int[10];
        Queue<int[]> queue = new LinkedList<int[]>();
        int target = -1;
        
        for(int i = 0; i < priorities.length; i++){
            queue.add(new int[] {priorities[i], i});
            priority[priorities[i]]++;
            if(i == location) target = i;
        }
        
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int currentPriority = -1;
            
            for(int i = 9; i > 0; i--){
                if(priority[i] != 0){
                    currentPriority = i;
                    break;
                }
            }
            
            if(temp[1] == target){
                if(temp[0] == currentPriority) break;
                queue.add(temp);
            } else{
                if(temp[0] != currentPriority) queue.add(temp);
                else {
                    priority[temp[0]]--;
                    answer++;
                }
                
            }
        }    
        return answer;
    }
}
