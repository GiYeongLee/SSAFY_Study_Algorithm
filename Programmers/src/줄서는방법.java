import java.util.*;

public class 줄서는방법 {
    public static void main(String[] args) {
        int n = 4;
        long k = 5;
        System.out.println(Arrays.toString(solution(n, k)));
    }

    static int[] arr;
    static int[] answer;
    static boolean[] selected;
    static int count = 0;

    static int[] solution(int n, long k) {
        arr = new int[3];
        answer = new int[3];
        selected = new boolean[3];
        func(n, k, 0);
        return answer;
    }
    
    static void func(int n, long k, int cnt) {
        if (cnt == n) {
            count++;
            if (count == k) {
                answer = arr.clone();
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (selected[i]) {
                continue;
            }
            selected[i] = true;
            arr[cnt] = i + 1;
            func(n, k, cnt + 1);
            selected[i] = false;
        }
    }
}
