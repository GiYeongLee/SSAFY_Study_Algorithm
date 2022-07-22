import java.util.*;

public class 괄호변환 {
    public static void main(String[] args) {
        String p = "(()))(";
        System.out.println(solution(p));
    }

    public static String solution(String p) {
        if (check(p)) return p;
        return func(p);
    }
    
    public static String func(String p) {
        // step 1
        if (p.length() == 0) return p;

        // step 2
        int leftCount = 0;
        int rightCount = 0;
        String leftString = "";
        String rightString = "";

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') leftCount++;
            else rightCount++;

            if (leftCount == rightCount) {
                leftString = p.substring(0, i + 1);
                rightString = p.substring(i + 1, p.length());
                break;
            }
        }

        // step 3
        if (check(leftString)) return leftString + func(rightString);
        
        // step 4
        else {
            // step 4-1 ~ 4-3
            rightString = "(" + func(rightString) + ")";

            // step 4-4
            leftString = leftString.substring(1, leftString.length() - 1);

            for (int i = 0; i < leftString.length(); i++) {
                switch(leftString.charAt(i)) {
                    case '(':
                        rightString += ")";
                        break;
                    case ')':
                        rightString += "(";
                        break;
                }
            }

            // step 5
            return rightString;
        }

    }

    public static boolean check(String p) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < p.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(p.charAt(i));
                continue;
            }

            switch (p.charAt(i)) {
                case '(':
                    if (stack.peek() == ')') stack.pop();
                    else stack.push(p.charAt(i));
                    break;
                case ')':
                    if (stack.peek() == ')') stack.pop();
                    else stack.push(p.charAt(i));
                    break;
            }
        }
        if(stack.size() > 0) return false;
        return true;
    }
}
