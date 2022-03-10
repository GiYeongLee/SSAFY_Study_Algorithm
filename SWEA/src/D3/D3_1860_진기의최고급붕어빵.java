package D3;

import java.util.*;
import java.io.*;

public class D3_1860_진기의최고급붕어빵 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int TC = Integer.parseInt(in.readLine());

        for (int t = 1; t <= TC; t++) {

            String[] splited = in.readLine().split(" ");

            int N = Integer.parseInt(splited[0]);
            int[] person = new int[N];
            int M = Integer.parseInt(splited[1]);
            int K = Integer.parseInt(splited[2]);

            splited = in.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                person[i] = Integer.parseInt(splited[i]);
            }

            Arrays.sort(person);

            int count = 0;
            int idx = 0;
            for (int i = 0; i <= person[N - 1]; i++) {
                if (i != 0 && i % M == 0) {
                    count += K;
                }

                if (i == person[idx]) {
                    count--;
                    idx++;
                }

                if (count < 0) {
                    builder.append("#" + t + " Impossible\n");
                    break;
                }

                if (i == person[N - 1]) {
                    builder.append("#" + t + " Possible\n");
                    break;
                }
            }
        }
        System.out.println(builder.toString());
    }
}
