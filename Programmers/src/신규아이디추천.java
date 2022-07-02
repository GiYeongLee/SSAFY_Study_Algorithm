public class 신규아이디추천 {
    public static void main(String[] args) {
        String new_id = "=.=";
        System.out.println(solution(new_id));
    }

    public static String solution(String new_id) {
        String answer = new_id.toLowerCase();
        
        String temp = "";
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) >= 'a' && answer.charAt(i) <= 'z') {
                temp += answer.charAt(i);
            } else if (answer.charAt(i) >= '0' && answer.charAt(i) <= '9') {
                temp += answer.charAt(i);
            } else if (answer.charAt(i) == '-' || answer.charAt(i) == '_' || answer.charAt(i) == '.') {
                temp += answer.charAt(i);
            }
        }
        answer = temp;

        while (answer.contains("..")) {
            answer = answer.replace("..", ".");
        }
        
        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }

        if (answer.length() > 0 && answer.charAt(0) == '.') {
            answer = answer.substring(1, answer.length());
        }

        if (answer.equals("")) {
            answer = "a";
        }

        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
        }

        if (answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }

        if (answer.length() < 3) {
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }

        return answer;
    }
}
