import java.io.*;

public class BJ_2980_도로와신호등 {

    static class Data {
        int Red;
        int Green;

        public Data(int red, int green) {
            Red = red;
            Green = green;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] splited = in.readLine().split(" ");
        int N = Integer.parseInt(splited[0]);
        int L = Integer.parseInt(splited[1]);

        Data[] data = new Data[L + 1];

        for (int i = 0; i < N; i++) {
            splited = in.readLine().split(" ");
            int D = Integer.parseInt(splited[0]);
            int R = Integer.parseInt(splited[1]);
            int G = Integer.parseInt(splited[2]);
            data[D] = new Data(R, G);
        }

        int count = 0;
        int loc = 0;

        while (loc < L) {
            count++;
            loc++;

            if (data[loc] != null) {
                int temp = count % (data[loc].Red + data[loc].Green);
                if (temp <= data[loc].Red) {
                    count += data[loc].Red - temp;
                }
            }
        }
        System.out.println(count);
    }
}
