import java.util.*;

public class 짝지어제거하기 {
    public static void main(String[] args) {
        String s = "cdcd";
        System.out.println(solution(s));
    }
    
    public static int solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        stack.add(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }
        }
        
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
