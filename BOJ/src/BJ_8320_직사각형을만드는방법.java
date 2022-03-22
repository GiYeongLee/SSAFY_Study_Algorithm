import java.io.*;

public class BJ_8320_직사각형을만드는방법 {
    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int count = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = i; i * j <= N; j++) {
                count++;
            }
        }

        System.out.println(count);
    }
}
