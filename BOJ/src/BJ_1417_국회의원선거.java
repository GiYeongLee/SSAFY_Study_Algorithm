import java.util.*;
import java.io.*;

public class BJ_1417_국회의원선거 {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int P = Integer.parseInt(in.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[N - 1];
        int count = 0;

        for (int i = 0; i < N - 1; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(arr);

        while (P <= arr[arr.length - 1]) {
            P++;
            arr[arr.length - 1]--;
            count++;
            Arrays.sort(arr);
        }

        System.out.println(count);
    }

}
