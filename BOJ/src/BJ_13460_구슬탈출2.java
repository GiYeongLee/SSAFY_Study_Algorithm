import java.util.*;
import java.io.*;

public class BJ_13460_구슬탈출2 {
    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] splited = in.readLine().split(" ");

        int N = Integer.parseInt(splited[0]);
        int M = Integer.parseInt(splited[1]);

        char[][] grid = new char[N][M];

        for (int i = 0; i < N; i++) {
            splited = in.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(splited[j]);
            }
        }

    }
}
