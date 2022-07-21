public class n진수게임 {
    public static void main(String[] args) {
        int n = 2;  // 진법
        int t = 4;  // 미리 구할 숫자의 갯수
        int m = 2;  // 게임에 참가하는 인원
        int p = 1;  // 튜브의 순서
        System.out.println(solution(n, t, m, p));
    }
    
    public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        builder.append(0);

        int i = 1;
        while (builder.length() < m * t) {
            builder.append(func(n, i++));
        }

        for (i = p - 1; i < m * (t - 1) + p; i += m) {
            answer.append(builder.charAt(i));
        }

        return answer.toString();
    }
    
    public static String func(int n, int length) {
        String nums[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        if(length < n){
            return nums[length];
        } else {
            return func(n, length / n) + nums[length % n];
        }
    } 
}
