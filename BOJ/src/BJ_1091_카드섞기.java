import java.io.*;

public class BJ_1091_카드섞기 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        int[] P = new int[N];
        int[] S = new int[N];

        String[] splited = in.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(splited[i]);
        }

        splited = in.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(splited[i]);
        }

        int[] checkCycle = P.clone();
        int count = 0;

        while (check(P, N)) {
            int[] temp = new int[N];
            for (int i = 0; i < N; i++) {
                temp[S[i]] = P[i];
            }

            if (checkCycle(temp, checkCycle, N)) {
                System.out.println(-1);
                return;
            }
            P = temp.clone();

            count++;
        }
        System.out.println(count);
    }

    public static boolean check(int[] P, int N) {
        for (int i = 0; i < N; i++) {
            if (P[i] != (i % 3))
                return true;
        }
        return false;
    }

    public static boolean checkCycle(int[] P, int[] checkCycle, int N) {
        for (int i = 0; i < N; i++) {
            if (P[i] != checkCycle[i])
                return false;
        }
        return true;
    }

}
