import java.io.*;

public class BJ_1592_영식이와친구들 {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] splited = in.readLine().split(" ");

        int N = Integer.parseInt(splited[0]);
        int M = Integer.parseInt(splited[1]); // 한 사람이 M번 받으면 게임 끝
        int L = Integer.parseInt(splited[2]);

        int[] arr = new int[N];

        int idx = 0;
        int count = 0;

        while (true) {
            arr[idx]++;
            if (arr[idx] % 2 == 0) {
                if (arr[idx] == M) {
                    break;
                }
                idx = (idx + L) % N;
            } else {
                if (arr[idx] == M) {
                    break;
                }
                idx -= L;
                if (idx < 0) {
                    idx = N - Math.abs(idx);
                }

            }
            count++;
        }
        System.out.println(count);
    }

}
