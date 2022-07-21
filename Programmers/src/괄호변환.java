public class 괄호변환 {
    public static void main(String[] args) {
        String p = ")(";
        System.out.println(solution(p));
    }

    public static String solution(String p) {
        if (check(p)) {
            return p;
        }
        return func(p);
    }
    
    public static String func(String p) {
        // step 1
        if (p.length() == 0) {
            return p;
        }

        // spep 2
        int leftCount = 0;
        int rightCount = 0;

        String leftTemp = "";
        String rightTemp = "";

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }

            if (leftCount == rightCount) {
                leftTemp = p.substring(0, i + 1);
                rightTemp = p.substring(i + 1, p.length());
                break;
            }
        }

        // step 3
        if (check(leftTemp)) {
            return leftTemp + func(rightTemp);
        }
        
        // step 4
        else {
            // step 4-1 ~ 4-3
            rightTemp = "(" + func(rightTemp) + ")";

            // step 4-4
            leftTemp = leftTemp.substring(1, leftTemp.length() - 1);

            for (int i = 0; i < leftTemp.length(); i++) {
                switch (leftTemp.charAt(i)) {
                    case '(':
                        rightTemp += ")";
                        break;
                    case ')':
                        rightTemp += "(";
                        break;
                }
            }

            // step 5
            return rightTemp;
        }

    }

    public static boolean check(String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            switch (p.charAt(i)) {
                case '(':
                    count++;
                    break;
                case ')':
                    count--;
                    if (count < 0) {
                        return false;
                    }
            }
        }
        return true;
    }
}
