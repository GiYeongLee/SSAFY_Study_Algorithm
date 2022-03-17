import java.io.*;

public class BJ_2798_블랙잭 {
    static int[] arr = new int[3];
    static int max = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] splited = in.readLine().split(" ");

        int N = Integer.parseInt(splited[0]);
        int M = Integer.parseInt(splited[1]);

        int[] input = new int[N];

        splited = in.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(splited[i]);
        }

        func(0, 0, N, M, input, 0);
        System.out.println(max);
    }

    public static void func(int cnt, int idx, int N, int M, int[] input, int sum) {
        if (cnt == 3) {
            if (sum <= M && sum > max) {
                max = sum;
            }
            return;
        }

        for (int i = idx; i < N; i++) {
            arr[cnt] = input[i];
            func(cnt + 1, i + 1, N, M, input, sum + input[i]);
        }
    }
}
