import java.io.*;
import java.util.*;

public class BJ_11399_ATM {
    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] P = new int[N];

        String[] splited = in.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(splited[i]);
        }

        Arrays.sort(P);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                sum += P[j];
            }
        }

        System.out.println(sum);
    }

}
