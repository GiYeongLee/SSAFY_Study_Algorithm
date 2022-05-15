import java.util.*;

public class 크레인인형뽑기게임 {

	public static void main(String[] args) {
		int[][] board = new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = new int[] {1,5,3,5,1,2,1,4};
		
		System.out.println(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        int height = board[0].length;
        int width = board.length;
        
        ArrayList<Stack<Integer>> stackList = new ArrayList<Stack<Integer>>();
        for(int i = 0; i < width; i++) {
        	stackList.add(new Stack<Integer>());
        }
        
        for(int i = height - 1; i >= 0; i--) {
        	for(int j = 0; j < width; j++) {
        		if(board[i][j] == 0) continue;
        		stackList.get(j).add(board[i][j]);
        	}
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < moves.length; i++) {
        	if(stackList.get(moves[i] - 1).size() == 0) continue;
        	int item = stackList.get(moves[i] - 1).pop();
        	if(stack.size() != 0 && stack.peek() == item) {
        		stack.pop();
        		answer += 2;
        	} else {
        		stack.add(item);
        	}
        }
        
        return answer;
    }

}
