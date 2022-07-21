import java.util.*;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = { 3, 0, 6, 1, 5 };
        System.err.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int count = citations.length - i;
            if (count <= citations[i]) {
                answer = count;
                break;
            }
        }

        return answer;
    }
}
